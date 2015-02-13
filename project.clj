(defproject bug "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.7.0-alpha5"]
                 [org.clojure/clojurescript "0.0-2760"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]]
  :plugins [[lein-cljsbuild "1.0.4"]]
  :source-paths ["src"]
  :cljsbuild { 
    :builds [
             {:id "main"
              :source-paths ["src"]
              :compiler {
                :output-to "build/main.js"
                :output-dir "build/"
                :optimizations :advanced
                :pretty-print true
                :source-map "build/main.map"}}]})
