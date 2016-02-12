package com.shail99.businessLogic;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Directory {
	
	private String path;
	@SerializedName("name")
	private String text;
	
	@SerializedName("children")
	private List<Directory> nodes;
	
	public String getText(){
		return text;
	}
	public String getPath() {
		return path;
	}
	public void setText(String text){
		this.text = text;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public List<Directory> getNodes() {
		return nodes;
	}
	public void setNodes(List<Directory> nodes) {
		this.nodes = nodes;
	}
	public Directory(String path, List<Directory> nodes) {
		super();
		this.path = path;
		this.nodes = nodes;
	}
	public Directory() {
		super();
	}
	
	public Directory convertDirToJsonFile(File file)
	{
		List<Directory> child_directories = new ArrayList<Directory>();
		Directory dir = new Directory();
		dir.setText(file.getName());
		dir.setPath(file.getAbsolutePath());
		
		if(file.isDirectory())
		{
			File[] file_array = file.listFiles();
			if(file_array.length != 0)
			{
				for(File temp_file : file_array)
				{
					Directory temp_dir = convertDirToJsonFile(temp_file);
					child_directories.add(temp_dir);
				}
				dir.setNodes(child_directories);
			}
		}	
		return dir;
	}

	public void printDirectoryStructure(int level) {
		// TODO Auto-generated method stub
		System.out.println("Level: "+level+"Path: "+this.getPath());
		
		if(this.getNodes() != null)
		{
			for(Directory sub_dir : this.getNodes())
			{
				sub_dir.printDirectoryStructure(level+1);
			}
		}
		
	}
	
//	public static void main(String args[])
//	{
//		File root_dir = new File("/Users/shaileshpujari/paymentTimingLogs/20160212");
//		Directory my_dir = new Directory();
//		my_dir = my_dir.convertDirToJsonFile(root_dir);
//		my_dir.printDirectoryStructure(0);
//	}


}
