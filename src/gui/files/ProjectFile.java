package gui.files;

import java.io.File;

import javax.swing.filechooser.FileFilter;

import gui.constants.Constants;


public class ProjectFile extends FileFilter {

	@Override
	public boolean accept(File f) {
		return (f.isDirectory() || f.getName().endsWith(Constants.PROJECT_EXTENSION));
	}

	@Override
	public String getDescription() {
		return "GeKoSeM project (" + Constants.PROJECT_EXTENSION + ")";
	}

}
