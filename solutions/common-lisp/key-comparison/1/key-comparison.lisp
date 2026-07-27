(defpackage :key-comparison
  (:use :cl)
  (:export
   :key-object-identity
   :key-numbers
   :key-numbers-of-different-types
   :key-characters
   :key-characters-case-insensitively
   :key-strings
   :key-strings-case-insensitively
   :key-conses-of-symbols
   :key-conses-of-characters
   :key-conses-of-numbers
   :key-conses-of-characters-case-insensitively
   :key-conses-of-numbers-of-different-types
   :key-arrays
   :key-arrays-loosely))
(in-package :key-comparison)

(defun key-object-identity (x y) (eq x y))
(defun key-numbers (x y) (eql x y))
(defun key-numbers-of-different-types (x y) (equalp x y))
(defun key-characters (x y) (char= x y))
(defun key-characters-case-insensitively (x y) (char-equal x y))
(defun key-strings (x y) (equal x y))
(defun key-strings-case-insensitively (x y) (string-equal x y))

;; This looks bad, but don't let that fool you. It really is bad.
(defun cons-compare (fn x y) 
  (cond 
    ((not (funcall fn (car x) (car y))) nil)
    ((not (funcall fn (cdr x) (cdr y))) nil)
    (t t)))

(defun key-conses-of-symbols (x y) (cons-compare #'eq x y))
(defun key-conses-of-characters (x y) (cons-compare #'char= x y))
(defun key-conses-of-numbers (x y) (cons-compare #'equal x y))
(defun key-conses-of-characters-case-insensitively (x y) (cons-compare #'equalp x y))
(defun key-conses-of-numbers-of-different-types (x y) (cons-compare #'equalp x y))
(defun key-arrays (x y) (equal x y))
(defun key-arrays-loosely (x y) (equalp x y))
