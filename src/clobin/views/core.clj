(ns clobin.views.core
  (:require [clobin.templates :as t]
            [clobin.models.paste :as p]
            [noir.response :as resp])
  (:use [noir.core :only [defpage]]
        [hiccup.core :only [html]]))

(defpage "/" []
         (t/index))

(defpage [:post "/"] {:keys [text language]}
         (resp/redirect (str "/paste/" (p/add! {:paste text :language language}))))

(defpage "/paste/:id" {:keys [id]}
         (let [paste-entry (p/get! {:pid id})]
           (println paste-entry)
           (t/paste (p/get! {:pid id}))))
