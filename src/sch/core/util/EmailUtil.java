package sch.core.util;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
/**
 * Email的工具類
 * @author Jason
 *
 */
@SuppressWarnings("static-access")
public class EmailUtil {
	
	private static Properties prop = new Properties();
	private static String host;
	private static int port;
	private static String username;
	private static String password;
	private static Session session;
	private static Message message;
	private static final String DEFAULT_MESSAGE = "";
	
	static {
		try {
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("mail.properties"));
			
			username = prop.getProperty("mail.smtp.username");
			password = prop.getProperty("mail.smtp.password");
			host = prop.getProperty("mail.smtp.host");
			port = Integer.parseInt(prop.getProperty("mail.smtp.port"));
			
			session = Session.getInstance(prop, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username,	password);
				}
			});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 寄送一般Email
	 * @param Subject Email主旨
	 * @param paramString Email內容(可使用html語法)
	 * @param sendEmail 收件者Email
	 * @throws MessagingException
	 * @throws AddressException
	 */
	public static void sendText(String Subject, String paramString , String emailUrl) throws MessagingException ,AddressException {
		formatMessage(Subject,paramString ,emailUrl);
	}
	
	/**
	 * 寄送一個檔案的Email(不含文字)
	 * @param Subject 主旨
	 * @param file 檔案
	 * @param emailUrl 收件人Email
	 * @throws MessagingException
	 * @throws AddressException
	 * @throws IOException
	 */	
	public static void sendFile(String Subject, File file , String emailUrl) throws MessagingException ,AddressException, IOException {		
		File files[] = {file};
 		formatMessage(Subject, emailUrl, files);
	}
	
	/**
	 * 寄送一個檔案的Email(不含文字)
	 * @param Subject 主旨
	 * @param file 檔案
	 * @param emailUrl 收件人Email
	 * @throws MessagingException
	 * @throws AddressException
	 * @throws IOException
	 */
	public static void sendFile(String Subject, String file , String emailUrl) throws MessagingException ,AddressException, IOException {
		sendFile(Subject, new File(file), emailUrl);
	}	
	
	/**
	 * 寄送包含多個檔案的Email(不含文字)
	 * @param Subject 主旨
	 * @param files 檔案
	 * @param emailUrl 收件人Email
	 * @throws MessagingException
	 * @throws AddressException
	 * @throws IOException
	 */	
	public static void sendFiles(String Subject, File[] files , String emailUrl) throws MessagingException ,AddressException, IOException {
		formatMessage(Subject, emailUrl, files);
	}
	
	/**
	 * 寄送包含多個檔案的Email(不含文字)
	 * @param Subject 主旨
	 * @param files 檔案
	 * @param emailUrl 收件人Email
	 * @throws MessagingException
	 * @throws AddressException
	 * @throws IOException
	 */
	public static void sendFiles(String Subject, String[] files , String emailUrl) throws MessagingException ,AddressException, IOException {
		File tempFiles[] = new File[files.length];
		for (int i = 0; i < files.length; i++) {
			tempFiles[i] = new File(files[i]);
		}
		sendFiles(Subject, tempFiles, emailUrl);
	}
	
	/**
	 * 寄送Email(文字與一個檔案)
	 * @param Subject 主旨
	 * @param text 文字(可使用html語法)
	 * @param file 檔案
	 * @param emailUrl 收件人Email
	 * @throws MessagingException
	 * @throws AddressException
	 * @throws IOException
	 */	
	public static void sendFileAndText(String Subject, String text, File file, String emailUrl) throws MessagingException ,AddressException, IOException {
		File files[] = {file};
		formatMessage(Subject, emailUrl);
		formatMulti(files, text);
	}
	
	/**
	 * 寄送Email(文字與一個檔案)
	 * @param Subject 主旨
	 * @param text 文字(可使用html語法)
	 * @param file 檔案
	 * @param emailUrl 收件人Email
	 * @throws MessagingException
	 * @throws AddressException
	 * @throws IOException
	 */
	public static void sendFileAndText(String Subject, String text, String file, String emailUrl) throws MessagingException ,AddressException, IOException {
		sendFileAndText(Subject, text, new File(file), emailUrl);
	}
	
	/**
	 * 寄送Email(文字與多個檔案)
	 * @param Subject 主旨
	 * @param text 文字(可使用html語法)
	 * @param files 檔案
	 * @param emailUrl 收件人Email
	 * @throws MessagingException
	 * @throws AddressException
	 * @throws IOException
	 */	
	public static void sendFilesAndText(String Subject, String text, File[] files , String emailUrl) throws MessagingException ,AddressException, IOException {
		formatMessage(Subject, emailUrl);
		formatMulti(files, text);
	}
	
	/**
	 * 寄送Email(文字與多個檔案)
	 * @param Subject 主旨
	 * @param text 文字(可使用html語法)
	 * @param files 檔案
	 * @param emailUrl 收件人Email
	 * @throws MessagingException
	 * @throws AddressException
	 * @throws IOException
	 */
	public static void sendFilesAndText(String Subject, String text, String[] files , String emailUrl) throws MessagingException ,AddressException, IOException {
		File tempFiles[] = new File[files.length];
		for (int i = 0; i < files.length; i++) {
			tempFiles[i] = new File(files[i]);
		}
		sendFilesAndText(Subject, text, tempFiles, emailUrl);
	}	
	
	/**
	 * 處理發送的訊息
	 * @param files
	 * @throws MessagingException 
	 * @throws IOException 
	 */
	private static void formatMulti(File files[]) throws MessagingException, IOException {
		formatMulti(files , DEFAULT_MESSAGE);
	}
	
	/**
	 * 處理發送的訊息
	 * @param files
	 * @param text
	 * @throws MessagingException
	 * @throws IOException
	 */
	private static void formatMulti(File files[], String text) throws MessagingException, IOException {
		//將要傳送的檔案加入到Multipart
        Multipart mp = new MimeMultipart();
        MimeBodyPart mbp;
        MimeBodyPart htmlmbp = new MimeBodyPart();
       
        htmlmbp.setContent(text, "text/html; charset=utf-8");
		for(int i = 0; i < files.length; i++) {
			mbp = new MimeBodyPart();
	        mbp.setHeader("Content-Type",  "application/octet-stream; charset=\"utf-8\"");
	        mbp.attachFile(files[i]);
	        mbp.setFileName(MimeUtility.encodeText(files[i].getName(), "UTF-8", "B")); //附加檔在mail接收時，使用utf-8解碼(解決中文亂碼)
	        mp.addBodyPart(mbp);
		}
		
		mp.addBodyPart(htmlmbp);
		message.setContent(mp);
		send(message);
	}
	
	/**
	 * 格式化Message
	 * @param Subject
	 * @param emailUrl
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	private static void formatMessage(String Subject, String emailUrl) throws AddressException, MessagingException {
		message = new MimeMessage(session);
		message.setFrom(new InternetAddress(username));
		message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(emailUrl));
		message.setSubject(Subject);
	}
	
	/**
	 * 格式化Message
	 * @param Subject
	 * @param paramString
	 * @param emailUrl
	 * @throws AddressException
	 * @throws MessagingException
	 */
	private static void formatMessage(String Subject, String paramString , String emailUrl) throws AddressException, MessagingException {		
		formatMessage(Subject, emailUrl);
		message.setContent(paramString, "text/html; charset=utf-8");
		send(message);
	}
	
	/**
	 * 格式化Message
	 * @param Subject
	 * @param emailUrl
	 * @param files
	 * @throws AddressException
	 * @throws MessagingException
	 * @throws IOException
	 */
	private static void formatMessage(String Subject, String emailUrl, File[] files) throws AddressException, MessagingException, IOException {
		formatMessage(Subject, emailUrl);
		formatMulti(files);
	}
	
	/**
	 * 寄送Email
	 * @param message
	 * @param mp
	 * @throws MessagingException 
	 */	
	private static void send(Message message) throws MessagingException {
		Transport transport = null;
		
		try {
			transport = session.getTransport("smtp");
			transport.connect(host, port, username, password);
			transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
			throw new MessagingException("smtpServer的設定有誤");
		} finally {
			try {
				if(transport != null)
					transport.close();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
}