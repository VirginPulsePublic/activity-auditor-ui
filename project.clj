(defproject
  activityAuditorUI
  "0.1.0-SNAPSHOT"
  :dependencies [[ring-server "0.3.1"]
                 [environ "0.4.0"]
                 [com.taoensso/timbre "2.7.1"]
                 [markdown-clj "0.9.40"]
                 [korma "0.3.0-RC6"]
                 [com.taoensso/tower "2.0.0"]
                 [selmer "0.5.7"]
                 [sonian/carica "1.1.0"]
                 [org.clojure/clojure "1.5.1"]
                 [org.clojure/core.incubator "0.1.3"]
                 [log4j
                  "1.2.17"
                  :exclusions
                  [javax.mail/mail
                   javax.jms/jms
                   com.sun.jdmk/jmxtools
                   com.sun.jmx/jmxri]]
                 [compojure "1.1.6"]
                 [lib-noir "0.7.9"]
                 [org.clojure/java.jdbc "0.3.0-alpha4"]
                 [ragtime/ragtime.sql.files "0.3.4"]
                 [com.postspectacular/rotor "0.1.0"]
                 [org.postgresql/postgresql "9.2-1002-jdbc4"]]
  :ragtime {:migrations ragtime.sql.files/migrations
            :database "jdbc:derby:/tmp/mydb;create=true"}
  :ring
  {
   :handler activityAuditorUI.handler/app,
   :init activityAuditorUI.handler/init,
   :destroy activityAuditorUI.handler/destroy
  }
  :profiles
  {
   :production
     {
        :ring {:open-browser? false, :stacktraces? false, :auto-reload? false}
        :env {:profile "prod"}
      },
   :staging
     {
        :ring {:open-browser? false, :stacktraces? false, :auto-reload? false}
        :env {:profile "staging"}
      },
   :qa
     {
        :ring {:open-browser? false, :stacktraces? false, :auto-reload? false}
        :env {:profile "qa"}
      },
   :dev
     {
      :dependencies [[ring-mock "0.1.5"] [ring/ring-devel "1.2.1"]],
      :env {:selmer-dev true :profile "dev"}
     }
  }
  :resource-paths ["resources" "config"]
  :url "https://github.com/VirginPulsePublic/activity-auditor-ui"
  :aot
  :all
  :plugins [[lein-ring "0.8.7"] [lein-environ "0.4.0"] [ragtime/ragtime.lein "0.3.4"]]
  :description "AngularJS/Clojure MVC UI for activity-auditor"
  :min-lein-version "2.0.0")
