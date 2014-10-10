(ns activityAuditorUI.routes.home
  (:use compojure.core)
  (:require [noir.io :as io]
            [noir.response :as response]
            [activityAuditorUI.models.db :as db]))

(defroutes home-routes
  (GET "/" [] (io/get-resource "/index.html"))
  (POST "/search" [query] (noir.response/content-type
       "application/json" (db/search-activities query))))
