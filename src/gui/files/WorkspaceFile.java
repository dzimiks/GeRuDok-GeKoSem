package gui.files;

import java.io.File;

import javax.swing.filechooser.FileFilter;

import gui.constants.Constants;


public class WorkspaceFile extends FileFilter {

	@Override
	public boolean accept(File f) {
		return (f.isDirectory() || f.getName().endsWith(Constants.WORKSPACE_EXTENSION));
	}

	@Override
	public String getDescription() {
		return "GeKoSeM workspace (" + Constants.WORKSPACE_EXTENSION + ")";
	}
}