/************************************************************
 * An MoJ WebTeam Product
 * IAC Fees CPI
 * 06-Dec-2011
 * Warning this software is not licensed for re-use outside
 * the MoJ estate.
 * Copyright 2011 - 2011
 ************************************************************/
package uk.gov.hmcts.legacy.web.util;

import java.io.File;

// TODO: Auto-generated Javadoc
/**
 * The Class FileUtils.
 */
public class FileUtils {

	/**
	 * Attempts to recursively delete all files and sub folders from the
	 * supplied directory.
	 *
	 * @param path
	 *            the path to the directory that is to be emptied
	 * @return true if all files deleted, false if a file cannot be deleted
	 */
	public static boolean deleteDirContents(String path) {
		boolean deleted = true;
		File deleteDir = new File(path);

		if(deleteDir.exists() && deleteDir.isDirectory()) {
			File deleteFile;
			String[] files = deleteDir.list();
			for(String fileName : files){
				deleteFile = new File(fileName);
				if(deleteFile.isDirectory()){
					deleteDirContents(deleteFile.getAbsolutePath());
				}
				deleteFile.delete();
				deleted = deleteFile.exists();
				if(!deleted){
					break;
				}
			}
		}
		return deleted;
	}
}
