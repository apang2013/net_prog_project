
/*
 * Student:    Trung Nguyen, Yat Shing Pang
 * Email:      tnguyen2013@my.fit.edu, apang2013@my.fit.edu
 * Course:     CSE 4232
 * Project:    GOSSIP P2P, Milestone 5
*/

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class GET_OPT_UI {

	private int port;
	private String ip;
	private String msg = "";
	private String t_msg = "";
	private static String protocol = "";
	private static String path = "";
	private static int delay_time = 0;

	public GET_OPT_UI() {
	}

	public GET_OPT_UI(final String ip, final int port) {
		this.port = port;
		this.ip = ip;
		this.ip = this.ip.replace("\"", "");
	}

	public GET_OPT_UI(final String ip, final int port, final String msg) {
		this.port = port;
		this.ip = ip;
		this.msg = msg;
		this.ip = this.ip.replace("\"", "");
	}

	public GET_OPT_UI(final String ip, final int port, final String msg, final String t_msg) {
		this.port = port;
		this.ip = ip;
		this.msg = msg;
		this.t_msg = t_msg;
		this.ip = this.ip.replace("\"", "");
	}

	public void getOpt(final CommandLineParser parser, final String[] args) {

		final Options options = new Options();
		final Option op_port = Option.builder("p").longOpt("port").desc("port").hasArg().valueSeparator().required()
				.build();
		final Option IP = Option.builder("s") // IP address option
				.longOpt("IP").desc("IP/Server").hasArg().valueSeparator().required().build();
		final Option message = Option.builder("m") // message
				.longOpt("message").desc("message").hasArg().valueSeparator().build();
		final Option time_msg = Option.builder("t") // time of message
				.longOpt("time").desc("time").hasArg().valueSeparator().build();
		final Option dir = Option.builder("d").longOpt("directory").desc("directory").hasArg().valueSeparator().build();
		final Option tcp = Option.builder("T") // TCP
				.longOpt("TCP").desc("TCP").valueSeparator().build();
		final Option udp = Option.builder("U") // UDP
				.longOpt("UDP").desc("UDP").valueSeparator().build();

		final Option delay = Option.builder("D").longOpt("Delay").desc("Delay").hasArg().valueSeparator().build();

		final Option help = Option.builder("h").longOpt("help").build();

		options.addOption(op_port);
		options.addOption(help);
		options.addOption(IP);
		options.addOption(message);
		options.addOption(time_msg);
		options.addOption(tcp);
		options.addOption(udp);
		options.addOption(dir);
		options.addOption(delay);

		try {
			final CommandLine input = parser.parse(options, args);

			final HelpFormatter formatter = new HelpFormatter();

			for (final Option option : input.getOptions()) {

				if (option.getOpt().equals("h")) {
					formatter.printHelp("Usage:", options);
				} else if (option.getOpt().equals("p")) {
					System.out.println("Set port to: " + option.getValue());
					port = Integer.parseInt(option.getValue());
				} else if (option.getOpt().equals("s")) {
					System.out.println("Set ip to: " + option.getValue());
					ip = option.getValue();
				} else if (option.getOpt().equals("m")) {
					System.out.println("Set message to: " + option.getValue());
					msg = option.getValue();
				} else if (option.getOpt().equals("t")) {
					System.out.println("Set time to: " + option.getValue());
					t_msg = option.getValue();
				} else if (option.getOpt().equals("T")) {
					System.out.println("Set protocol to: TCP");
					protocol = "TCP";
				} else if (option.getOpt().equals("U")) {
					System.out.println("Set protocol to: UDP");
					protocol = "UDP";
				} else if (option.getOpt().equals("d")) {
					System.out.println("Set path to: " + option.getValue());
					path = option.getValue();
				} else if (option.getOpt().equals("D")) {
					System.out.println("Set delay time to: " + option.getValue());
					delay_time = Integer.parseInt(option.getValue());
				}
			}

		} catch (final ParseException e) {
			System.err.println("Parsing failed.\n" + e);
		}
	}

	public int getPort() {
		return port;
	}

	public String getIP() {
		return ip;
	}

	public String getMsg() {
		return msg;
	}

	public String getTime() {
		return t_msg;
	}

	public String getProtocol() {
		return protocol;
	}

	public String getPath() {
		return path;
	}

	public int getDelayTime() {
		return delay_time;
	}
}
