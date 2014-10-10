(ns activityAuditorUI.models.db
  (:use korma.core
        clojure.core.incubator
        korma.db)
  (:require [clojure.set :as st]
            [activityAuditorUI.models.schema :as schema]))

(defdb db (postgres schema/db-spec))

(defentity activity
  (database db)
  (table :activity_audit))

(defn search-activities [query]
  (select activity
    (where {:message [like (str "%" query "%")]})
      (order :timestamp :DESC)))
