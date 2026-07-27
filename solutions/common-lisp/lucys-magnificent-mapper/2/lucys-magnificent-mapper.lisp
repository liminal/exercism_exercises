(defpackage :lucys-magnificent-mapper
  (:use :cl)
  (:export :make-magnificent-maybe :only-the-best))

(in-package :lucys-magnificent-mapper)

;; Define make-magnificent-maybe function
(defun make-magnificent-maybe (test items) 
  (mapcar test items))

;; Define only-the-best function
(defun only-the-best (test items)
  (remove-if test (remove 1 items))) ; No need to complicate things by combining the tests for this dataset
