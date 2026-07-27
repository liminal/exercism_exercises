(defpackage :reporting-for-duty
  (:use :cl)
  (:export :format-quarter-value :format-two-quarters
           :format-two-quarters-for-reading))

(in-package :reporting-for-duty)

;; Define format-quarter-value function.
(defun format-quarter-value (quarter value)
  (format nil "The value ~a quarter: ~a" quarter value))

;; Define format-two-quarters function.
(defun format-two-quarters (stream q1 value1 q2 value2)
  (format stream "~%The value ~a quarter: ~a~%The value ~a quarter: ~a~%" q1 value1 q2 value2))

;; Define format-two-quarters-for-reading function.
(defun format-two-quarters-for-reading (stream q1 v1 q2 v2)
  (format stream "(\"The value ~a quarter: ~a\" \"The value ~a quarter: ~a\")" q1 v1 q2 v2))
