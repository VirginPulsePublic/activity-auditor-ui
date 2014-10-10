(ns activityAuditorUI.models.schema
  (:require [noir.io :as io]
            [environ.core :refer [env]]))
(use '[carica.core])

(println "in schema..")
(println (env :profile))

(def env-key (keyword (env :profile)))

(def db-spec {:db (config env-key :database :name)
              :user (config env-key :database :username)
              :password (config env-key :database :pass)
              :host (config env-key :database :hostname)
              :port (config env-key :database :portname)})
