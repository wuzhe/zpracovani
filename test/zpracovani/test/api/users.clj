(ns zpracovani.test.api.users
  (:use zpracovani.core
        zpracovani.util
        zpracovani.api.users
        zpracovani.test.properties
        re-rand
        clojure.data
        clojure.test))

(deftest users-test
  (with-credentials *parse-api-host* *parse-application-id* *parse-master-key*
    (let [user {:username (re-rand #"[A-Za-z0-9]{10}")
                :password (re-rand #"[A-Za-z0-9]{10}")}
          new-user (signup :user user)
          logged-in (login :username (:username user)
                           :password (:password user))]
      (is (= true (contains? new-user :objectId)))
      (is (= (:username user) (:username logged-in)))
      (is (= (dissoc logged-in :sessionToken)  (retrieve (:objectId new-user))))
      #_(is (contains?
           (update (:objectId new-user) :update {:rad "things"})
           :updatedAt))
      #_(is (= "things" (:rad (retrieve (:objectId new-user)))))
      (is (= (retrieve (:objectId new-user))
             (-> (query)
                 :results
                 first)))
      (is (= (retrieve (:objectId new-user))
             (-> (query :where
                        {:username (:username user)})
                       :results
                       first)))
      #_(is (= {}  (delete (:objectId new-user)))))))

