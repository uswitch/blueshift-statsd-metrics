(ns uswitch.blueshift.statsd
  (:require [com.stuartsierra.component :refer (Lifecycle)])
  (:import [com.readytalk.metrics StatsDReporter]
           [java.util.concurrent TimeUnit]))

(defn- reporter [config registry]
  (let [{:keys [host port interval]
         :or   {host     "localhost"
                port     8125}} config]
    (.build (StatsDReporter/forRegistry registry)
            host port)))

(defrecord Reporter [config registry]
  Lifecycle
  (start [this]
    (let [rep (reporter config registry)]
      (.start rep 1 TimeUnit/SECONDS)
      (assoc this :reporter rep)))
  (stop [this]
    (when-let [reporter (:reporter this)]
      (.stop reporter)
      (assoc this :reporter nil))))

(defn statsd-reporter [config registry]
  (map->Reporter {:config config :registry registry}))
