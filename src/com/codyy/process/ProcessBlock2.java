package com.codyy.process;

public class ProcessBlock2 {
	/*
	
	public static void main(String[] args) throws ExecuteException, IOException, InterruptedException {
	long startTime = System.currentTimeMillis();
	System.out.println(commonExec());
	System.out.println(commonExec2());
	// System.out.println(commonExec3());
	// getVideoTime();
	// commonExecImg();
	// imgs();
	concatVideo();
	long endTime = System.currentTimeMillis();
	
	System.out.println((endTime - startTime) / 1000);
	// System.out.println(concatVideo());
	}
	
	public static int concatVideo() throws ExecuteException, IOException, InterruptedException {
	CommandLine cmdLine = new CommandLine("D:\\ffmpeg.exe");
	cmdLine.addArgument("-f");
	cmdLine.addArgument("concat");
	cmdLine.addArgument("-y");
	cmdLine.addArgument("-safe");
	cmdLine.addArgument("0");
	cmdLine.addArgument("-i");
	cmdLine.addArgument("D:\\filelist.txt");
	cmdLine.addArgument("-c");
	cmdLine.addArgument("copy");
	cmdLine.addArgument("D:/out.flv");
	
	DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
	DefaultExecutor executor = new DefaultExecutor();
	executor.setExitValue(0);
	ExecuteWatchdog watchdog = new ExecuteWatchdog(600000);
	executor.setWatchdog(watchdog);
	executor.execute(cmdLine, resultHandler);
	resultHandler.waitFor();
	
	if (executor.isFailure(resultHandler.getExitValue())) {
	System.out.println("aaaa");
	}
	
	if (watchdog.killedProcess()) {
	System.out.println("dddd");
	}
	
	return resultHandler.getExitValue();
	}
	
	public static int commonExecImg() throws ExecuteException, IOException {
	CommandLine cmdLine = new CommandLine("D:\\ffmpeg.exe");
	cmdLine.addArgument("-ss");
	// cmdLine.addArgument("00:00:01");
	cmdLine.addArgument("1");
	cmdLine.addArgument("-i");
	cmdLine.addArgument("D:\\22.mp4");
	cmdLine.addArgument("-y");
	cmdLine.addArgument("-f");
	cmdLine.addArgument("image2");
	// cmdLine.addArgument("fps=fps=0.001");
	cmdLine.addArgument("-r");
	cmdLine.addArgument("0.1");
	cmdLine.addArgument("-t");
	// cmdLine.addArgument("00:01:20");
	cmdLine.addArgument("90");
	cmdLine.addArgument("D:/imgs/888888_%3d.png");
	
	DefaultExecutor executor = new DefaultExecutor();
	executor.setExitValue(0);
	int exitValue = executor.execute(cmdLine);
	
	return exitValue;
	}
	
	public static int imgs() throws ExecuteException, IOException {
	CommandLine cmdLine = new CommandLine("D:\\ffmpeg.exe");
	cmdLine.addArgument("-ss");
	cmdLine.addArgument("5");
	cmdLine.addArgument("-i");
	cmdLine.addArgument("D:\\11.flv");
	cmdLine.addArgument("-vf");
	cmdLine.addArgument("fps=1");
	cmdLine.addArgument("-t");
	cmdLine.addArgument("1");
	cmdLine.addArgument("D:/imgs/888888_%3d.jpg");
	
	DefaultExecutor executor = new DefaultExecutor();
	executor.setExitValue(0);
	int exitValue = executor.execute(cmdLine);
	
	return exitValue;
	}
	
	public static int commonExec() throws ExecuteException, IOException {
	CommandLine cmdLine = new CommandLine("D:\\ffmpeg.exe");
	cmdLine.addArgument("-ss");
	cmdLine.addArgument("11");
	cmdLine.addArgument("-i");
	cmdLine.addArgument("D:\\Wildlife.wmv");
	cmdLine.addArgument("-vframes");
	cmdLine.addArgument("1");
	cmdLine.addArgument("-y");
	cmdLine.addArgument("-f");
	cmdLine.addArgument("image2");
	cmdLine.addArgument("D:\\sample2.jpg");
	
	DefaultExecutor executor = new DefaultExecutor();
	executor.setExitValue(0);
	int exitValue = executor.execute(cmdLine);
	
	return exitValue;
	}
	
	public static int commonExec2() throws ExecuteException, IOException {
	CommandLine cmdLine = new CommandLine("D:\\ffmpeg.exe");
	cmdLine.addArgument("-ss");
	cmdLine.addArgument("11");
	cmdLine.addArgument("-i");
	cmdLine.addArgument("D:\\Wildlife.wmv");
	cmdLine.addArgument("-vframes");
	cmdLine.addArgument("1");
	cmdLine.addArgument("-y");
	cmdLine.addArgument("-f");
	cmdLine.addArgument("image2");
	cmdLine.addArgument("D:\\sample2.jpg");
	
	DefaultExecutor executor = new DefaultExecutor();
	executor.setExitValue(0);
	
	ExecuteWatchdog watchdog = new ExecuteWatchdog(5000);
	executor.setWatchdog(watchdog);
	int exitValue = executor.execute(cmdLine);
	
	return exitValue;
	}
	
	public static int commonExec3() throws ExecuteException, IOException, InterruptedException {
	CommandLine cmdLine = new CommandLine("D:\\ffmpeg.exe");
	cmdLine.addArgument("-ss");
	cmdLine.addArgument("11");
	cmdLine.addArgument("-i");
	cmdLine.addArgument("D:\\Wildlife.wmv");
	cmdLine.addArgument("-vframes");
	cmdLine.addArgument("1");
	cmdLine.addArgument("-y");
	cmdLine.addArgument("-f");
	cmdLine.addArgument("image2");
	cmdLine.addArgument("D:\\sample2.jpg");
	
	DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
	DefaultExecutor executor = new DefaultExecutor();
	executor.setExitValue(1);
	
	ExecuteWatchdog watchdog = new ExecuteWatchdog(5000);
	executor.setWatchdog(watchdog);
	executor.execute(cmdLine, resultHandler);
	resultHandler.waitFor();
	
	return 0;
	}
	
	*//** 
		* 获取视频总时间 
		* @param viedo_path    视频路径 
		* @param ffmpeg_path   ffmpeg路径 
		* @return 
		*/
	/*
	public static int getVideoTime() {
	CommandLine commands = new CommandLine("D:\\ffmpeg.exe");
	// commands.addArgument("-ss");
	// commands.addArgument("11");
	commands.addArgument("-i");
	commands.addArgument("D:\\video\\oo.flv");
	// commands.addArgument("-vframes");
	// commands.addArgument("1");
	// commands.addArgument("-y");
	// commands.addArgument("-f");
	// commands.addArgument("image2");
	// commands.addArgument("D:\\sample2.jpg");
	try {
	
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	
		ByteArrayOutputStream errorStream = new ByteArrayOutputStream();
	
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream, errorStream);
	
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
	
		ExecuteWatchdog watchdog = new ExecuteWatchdog(5000);
		executor.setWatchdog(watchdog);
		executor.setStreamHandler(streamHandler);
		executor.execute(commands, resultHandler);
		resultHandler.waitFor();
	
		String out = outputStream.toString("UTF-8");
	
		String error = errorStream.toString("UTF-8");
	
		System.out.println("out:" + out);
	
		System.out.println("error:" + error);
	
		// 从视频信息中解析时长
		String regexDuration = "Duration: (.*?), start: (.*?), bitrate: (\\d*) kb\\/s";
		Pattern pattern = Pattern.compile(regexDuration);
		Matcher m = pattern.matcher(error.toString());
		if (m.find()) {
			int time = getTimelen(m.group(1));
			System.out.println("视频时长：" + time + ", 开始时间：" + m.group(2) + ",比特率：" + m.group(3) + "kb/s");
			return time;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return 0;
	}
	
	// 格式:"00:00:10.68"
	private static int getTimelen(String timelen) {
	int min = 0;
	String strs[] = timelen.split(":");
	if (strs[0].compareTo("0") > 0) {
		min += Integer.valueOf(strs[0]) * 60 * 60;// 秒
	}
	if (strs[1].compareTo("0") > 0) {
		min += Integer.valueOf(strs[1]) * 60;
	}
	if (strs[2].compareTo("0") > 0) {
		min += Math.round(Float.valueOf(strs[2]));
	}
	return min;
	}
	*/}
