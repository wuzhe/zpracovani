(ns zpracovani.test.properties
  (:import (java.util.Properties)))

;; slurp in properties
(def ^:dynamic *props*
  (into {} (doto (java.util.Properties.)
             (.load (-> (Thread/currentThread)
                       (.getContextClassLoader)
                       (.getResourceAsStream "test.properties"))))))

(def ^:dynamic *parse-api-host*
  (or (get *props* "parse.host")
      (throw (Exception. "supply your provider api host"))))

(def ^:dynamic *parse-application-id*
  (or (get *props* "parse.application.id")
      (throw (Exception. "supply your Parse Application ID in resources/test.properties to run the tests"))))

(def ^:dynamic *parse-master-key*
  (or (get *props* "parse.master.key")
      (throw (Exception. "supply your Parse Master Key in resources/test.properties to run the tests"))))

(def ^:dynamic *zpracovani-test-class*
  (or (get *props* "zpracovani.test.class")
      (throw (Exception. "supply a test class name in resources/test.properties to run the tests"))))
