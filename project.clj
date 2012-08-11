(defproject clobin "0.1.0-SNAPSHOT"
            :description "FIXME: write this!"
            :dependencies [[org.clojure/clojure "1.4.0"]
                           [noir "1.3.0-beta1"]
                           [com.taoensso/carmine "0.10.1"]]
            :dev-dependencies [[org.clojars.scott/lein-nailgun "1.1.0"]
                               [vimclojure/server "2.3.3"]]
            :main clobin.server)
