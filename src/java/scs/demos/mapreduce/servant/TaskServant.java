package scs.demos.mapreduce.servant;

import scs.demos.mapreduce.FileSplit;
import scs.demos.mapreduce.TaskPOA;
import scs.demos.mapreduce.TaskStatus;

/**
 * Servant generico que implementa a interface scs::demos::mapreduce::Task
 * É especializado para encapsular tarefas map e reduce 
 * @author Sand Luz Correa
 */

public class TaskServant extends TaskPOA {

	private static int taskId = 0;
	private FileSplit[] inputSplit = null;
	private FileSplit[] outputSplit = null; 
	private TaskStatus status = null;
	private int id = 0;
	private int reduceIndex;


	public TaskServant(TaskStatus status, FileSplit[] inputSplit, int reduceIndex) {
		this.id = taskId++;
		this.status = status;
		this.inputSplit = inputSplit;
		this.reduceIndex = reduceIndex;
	}

	public int getId() {
		return id;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public void setOutput(FileSplit[] output) {
		this.outputSplit = output;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public FileSplit[] getInput() {
		return inputSplit;
	}

	public FileSplit[] getOutput() {
		return outputSplit;
	}

	public int getReduceIndex() {
		return reduceIndex;
	}

}         

