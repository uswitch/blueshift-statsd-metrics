(defproject uswitch/blueshift-statsd-metrics "0.1.0-SNAPSHOT"
  :description "StatsD metric reporting for Blueshift"
  :url "https://github.com/uswitch/blueshift-statsd-metrics"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [com.readytalk/metrics3-statsd "4.1.2"]
                 [com.stuartsierra/component "0.2.1"]]
  :repositories [["statsd-bintray" "https://dl.bintray.com/readytalk/maven/"]]
  :profiles {:provided {:dependencies [[metrics-clojure "2.0.2"]]}})
