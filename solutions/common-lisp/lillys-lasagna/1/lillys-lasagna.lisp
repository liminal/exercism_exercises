(defpackage :lillys-lasagna
  (:use :cl)
  (:export :expected-time-in-oven
           :remaining-minutes-in-oven
           :preparation-time-in-minutes
           :elapsed-time-in-minutes))

(in-package :lillys-lasagna)

;; Define function expected-time-in-oven
(defun expected-time-in-oven ()
  "Amount of time it takes to cook a lasagna"
  337)

;; Define function remaining-minutes-in-oven
(defun remaining-minutes-in-oven (time)
  "How much time is left to cook the lasagna after time minutes"
  (- (expected-time-in-oven) time))

;; Define function preparation-time-in-minutes
(defun preparation-time-in-minutes (layers)
  "Time it takes to prepare a lasagna of 'layers' layers"
  (* 19 layers))

;; Define function elapsed-time-in-minutes
(defun elapsed-time-in-minutes (layers minutes-in-oven)
  "How long it's taken to cook the lasagna so far"
  (+ (preparation-time-in-minutes layers) minutes-in-oven))
