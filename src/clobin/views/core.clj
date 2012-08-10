(ns clobin.views.core
  (:require [clobin.templates :as t])
  (:use [noir.core :only [defpage]]
        [hiccup.core :only [html]]))

(defpage "/" []
         (t/index))