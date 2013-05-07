(ns zpracovani.api.files
  (:use zpracovani.core))

(defmacro def-parse-files-method
  [name request-method action & [body-keyword]]
  `(def-parse-method ~name ~request-method ~action ~body-keyword))

;; create a file
;;
;;`(create "Hello.txt" :content-type "text/plain" :data "Hello, World!")`
(def-parse-files-method create :post "files/%s" :data)

;; delete a file
;;
;;`(delete "...Hello.txt")`
(def-parse-files-method delete :delete "files/%s")
