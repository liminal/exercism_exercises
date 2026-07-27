(defpackage :lillys-lasagna-leftovers
  (:use :cl)
  (:export
   :preparation-time
   :remaining-minutes-in-oven
   :split-leftovers))

(in-package :lillys-lasagna-leftovers)

;; Define function preparation-time
(defun preparation-time (&rest layers) 
                             (* 19 (length layers)))

;; Define function remaining-minutes-in-oven
(defun remaining-minutes-in-oven (&optional (type :normal))
  (case type
    (:normal 337)
    (:shorter 237)
    (:very-short 137)
    (:longer 437)
    (:very-long 537)
    (otherwise 0)))

;; Define function split-leftovers
(defun split-leftovers (&key (weight :just-split-it) (human 10) (alien 10))
  (cond 
    ((eq weight :just-split-it) :just-split-it)
    ((eq weight nil) :looks-like-someone-was-hungry)
    (t (- weight human alien))))
