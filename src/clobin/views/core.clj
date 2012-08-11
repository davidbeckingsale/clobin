(ns clobin.views.core
  (:require [clobin.templates :as t]
            [clobin.models.paste :as p]
            [noir.response :as resp])
  (:use [noir.core :only [defpage]]
        [hiccup.core :only [html]]))

(defpage "/" []
         (t/index))

(defpage [:post "/"] {:keys [text]}
         (resp/redirect (str "/paste/" (p/add! {:paste text}))))

(defpage "/paste/:id" {:keys [id]}
         (t/paste (p/get! {:pid id})))
