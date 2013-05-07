(defproject zpracovani "0.1.0"
  :description "zpracovani: parse.com API client in Clojure"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/data.json "0.2.2"]
                 [clj-http "0.7.2"]]
  :profiles {:dev {:dependencies [[marginalia "0.7.1"]
                                  [re-rand "0.1.0"]
                                  [lein-clojars "0.9.1"]]}})
