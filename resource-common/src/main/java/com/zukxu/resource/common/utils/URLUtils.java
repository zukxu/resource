package com.zukxu.resource.common.utils;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * <p>
 * URL检查测试工具类
 * </p>
 *
 * @author zukxu
 * @date 2021/1/19 0019 14:55
 */
public class URLUtils {
	private static URL url;
	private static HttpURLConnection con;
	private static int state = -1;

	public static void main(String[] args) {
		URLUtils utils = new URLUtils();
		int url = utils.isConnect("https://picjumbo.com/");
		System.out.println(url);
	}

	/**
	 * 功能：检测当前URL是否可连接或是否有效,
	 * 描述：最多连接网络 5 次, 如果 5 次都不成功，视为该地址不可用
	 *
	 * @param urlStr 指定URL网络地址
	 * @return URL
	 */
	public synchronized int isConnect(String urlStr) {
		int counts = 0;
		int results = -1;
		while (counts < 5) {
			try {
				url = new URL(urlStr);
				con = (HttpURLConnection) url.openConnection();
				state = con.getResponseCode();
				if (state == 200) {
					System.out.println("URL可用！");
					results = state;
				}
				break;
			} catch (Exception ex) {
				counts++;
				System.out.println("URL不可用，连接第 " + counts + " 次");
				urlStr = null;
				continue;
			}
		}
		return results;
	}

}
