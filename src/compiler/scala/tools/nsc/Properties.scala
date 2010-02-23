/* NSC -- new Scala compiler
 * Copyright 2006-2010 LAMP/EPFL
 * @author  Stephane Micheloud
 */

// $Id$

package scala.tools.nsc

/** Loads compiler.properties from the jar. */
object Properties extends scala.util.PropertiesTrait {
  protected def propCategory    = "compiler"
  protected def pickJarBasedOn  = classOf[Global]

  // settings based on jar properties
  def fileEndingString      = scalaPropOrElse("file.ending", ".scala|.java")
  def residentPromptString  = scalaPropOrElse("resident.prompt", "\nnsc> ")
  def shellPromptString     = scalaPropOrElse("shell.prompt", "\nscala> ")

  // settings based on system properties
  def msilLibPath           = propOrNone("msil.libpath")

  // derived values
  def isEmacsShell          = propIsSet("env.emacs")
  def fileEndings           = fileEndingString.split("""\|""").toList
}
