package com.tathvatech.user.entity;

import com.tathvatech.common.Asynch.AsyncProcessor;
import com.tathvatech.common.common.ApplicationProperties;
import com.tathvatech.common.common.FileStoreManager;
import com.tathvatech.common.common.TestSutraProperties;
import com.tathvatech.common.email.EmailMessageInfo;
import com.tathvatech.common.entity.AttachmentIntf;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class NotificationsDelegate {

	public static void notifyNewUserCreated(User user, String userPassword, boolean sendWelcomeKit) 
	{
		try {
			//you need user password passed since the password field inside user is encrypted.
			if(sendWelcomeKit && user.getEmail() != null)
			{
				File welcomeKit = FileStoreManager.getResourceFile(ApplicationProperties.welcomeKitFileName);
				if(welcomeKit != null)
				{
					StringBuffer sbHtml = new StringBuffer();
					sbHtml.append("Dear ").append(user.getFirstName()).append(" ").append(user.getLastName()).append(", <br/> <br/>")
						.append("A username and password has been created for you on TestSutra.<br/> <br/>") 
						.append("Username - ").append(user.getUserName()).append(" <br/>")
						.append("Password - ").append(userPassword).append(" <br/> <br/>")
						.append("You can access TestSutra from your web browser at<br/> <br/>")
						.append(TestSutraProperties.getSiteUrl() + "<br/> <br/>")
//						.append("Please find a quick introduction to TestSutra attached to this email <br/> <br/>")
						.append("If you have any questions or concerns, please send an email to <br/>")
						.append("testsutra.support@tathvatech.com <br/> <br/>")
						.append("Regards <br/>")
						.append("TestSutra Support <br/>");    			

					StringBuffer sbText = new StringBuffer();
					sbText.append("Dear ").append(user.getFirstName()).append(" ").append(user.getLastName()).append(", \r\n\r\n")
						.append("A username and password has been created for you on TestSutra.\r\n\r\n") 
						.append("Username - ").append(user.getUserName()).append("\r\n")
						.append("Password - ").append(userPassword).append("\r\n\r\n")
						.append("You can access TestSutra from your web browser at\r\n\r\n")
						.append(TestSutraProperties.getSiteUrl() + "\r\n\r\n")
//						.append("Please find a quick introduction to TestSutra attached to this email\r\n\r\n")
						.append("If you have any questions or concerns, please send an email to\r\n")
						.append("testsutra.support@tathvatech.com\r\n\r\n")
						.append("Regards\r\n")
						.append("TestSutra Support\r\n");    			

					List<AttachmentIntf> attachments = new ArrayList();
//					Attachment att = new Attachment();
//					att.setFileName(TestSutraProperties.welcomeKitFileName);
//					att.setFileDisplayName(TestSutraProperties.welcomeKitFileName);
//					attachments.add(att);
					EmailMessageInfo emailInfo = new EmailMessageInfo(ApplicationProperties.getEmailFromAddress(), null,
							new String[]{user.getEmail()}, "TestSutra access credentials", sbText.toString(), sbHtml.toString(), attachments);
					AsyncProcessor.scheduleEmail(emailInfo);
					
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void notifyPasswordReset(User user, String password)
	{
		if(user.getEmail() == null || user.getEmail().trim().length() == 0)
			return;
		try 
		{
			StringBuffer html = new StringBuffer();
			html.append("<font size='5'>Hi {emailToUser} </font><br/><br/>");
			html.append("Your user credentials on TestSutra has been updated. <br/><br/>");
			html.append("Please use the following username and password to login to your account.<br/><br/>");
			html.append("Username - {userName}<br/>"
					+ "Password - {password}<br/><br/>"
					+ "You can access TestSutra from your web browser at <br/><br/>"
					+ "{serverUrl}<br/><br/>"
					+ "If you have any questions or concerns, please send an email to {supportEmail} <br/><br/>");
			html.append("Thanks<br/>TestSutra Support<br/><br/>");
			html.append("Please do not respond to this email as this is auto-generated by TestSutra<br/>");

			String htmlA = html.toString();
			htmlA = htmlA.replace("{emailToUser}", user.getFirstName() + " " + user.getLastName());
			htmlA = htmlA.replace("{userName}", user.getUserName());
			htmlA = htmlA.replace("{password}", password);
			htmlA = htmlA.replace("{serverUrl}", TestSutraProperties.getSiteUrl());
			htmlA = htmlA.replace("{supportEmail}", "testsutra.support@tathvatech.com");
			
			
			StringBuffer text = new StringBuffer();
			text.append("Hi {emailToUser} \r\n\r\n");
			text.append("Your user credentials on TestSutra has been updated. \r\n\r\n");
			text.append("Please use the following username and password to login to your account.\r\n\r\n");
			text.append("Username - {userName}\r\n"
					+ "Password - {password}\r\n\r\n"
					+ "You can access TestSutra from your web browser at \r\n\r\n"
					+ "{serverUrl}\r\n\r\n"
					+ "If you have any questions or concerns, please send an email to {supportEmail} \r\n\r\n");
			text.append("Thanks\r\nTestSutra Support\r\n\r\n");
			text.append("Please do not respond to this email as this is auto-generated by TestSutra\r\n");
			
			String textA = text.toString();
			textA = textA.replace("{emailToUser}", user.getFirstName() + " " + user.getLastName());
			textA = textA.replace("{userName}", user.getUserName());
			textA = textA.replace("{password}", password);
			textA = textA.replace("{serverUrl}", TestSutraProperties.getSiteUrl());
			textA = textA.replace("{supportEmail}", "testsutra.support@tathvatech.com");
					
			EmailMessageInfo emailInfo = new EmailMessageInfo(ApplicationProperties.getEmailFromAddress(), null,
					new String[]{user.getEmail()}, "TestSutra User Credentials updated ", textA, htmlA, null);
			AsyncProcessor.scheduleEmail(emailInfo);
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void notifyPinReset(User user, String passPin)
	{
		if(user.getEmail() == null || user.getEmail().trim().length() == 0)
			return;
		try 
		{
			StringBuffer html = new StringBuffer();
			html.append("<font size='5'>Hi {emailToUser} </font><br/><br/>");
			html.append("Your quick access pin for TestSutra login has been updated. <br/><br/>");
			html.append("Please use the following username and pin to login to your account from the tablet.<br/><br/>");
			html.append("Username - {userName}<br/>"
					+ "Pin - {pin}<br/><br/>"
					+ "If you have any questions or concerns, please send an email to {supportEmail} <br/><br/>");
			html.append("Thanks<br/>TestSutra Support<br/><br/>");
			html.append("Please do not respond to this email as this is auto-generated by TestSutra<br/>");

			String htmlA = html.toString();
			htmlA = htmlA.replace("{emailToUser}", user.getFirstName() + " " + user.getLastName());
			htmlA = htmlA.replace("{userName}", user.getUserName());
			htmlA = htmlA.replace("{pin}", passPin);
			htmlA = htmlA.replace("{supportEmail}", "testsutra.support@tathvatech.com");
			
			
			StringBuffer text = new StringBuffer();
			text.append("Hi {emailToUser} \r\n\r\n");
			text.append("Your quick access pin for TestSutra login has been updated. \r\n\r\n");
			text.append("Please use the following username and pin to login to your account from the tablet.\r\n\r\n");
			text.append("Username - {userName}\r\n"
					+ "Pin - {pin}\r\n\r\n"
					+ "If you have any questions or concerns, please send an email to {supportEmail} \r\n\r\n");
			text.append("Thanks\r\nTestSutra Support\r\n\r\n");
			text.append("Please do not respond to this email as this is auto-generated by TestSutra\r\n");
			
			String textA = text.toString();
			textA = textA.replace("{emailToUser}", user.getFirstName() + " " + user.getLastName());
			textA = textA.replace("{userName}", user.getUserName());
			textA = textA.replace("{pin}", passPin);
			textA = textA.replace("{supportEmail}", "testsutra.support@tathvatech.com");
					
			EmailMessageInfo emailInfo = new EmailMessageInfo(ApplicationProperties.getEmailFromAddress(), null,
					new String[]{user.getEmail()}, "TestSutra quick access pin updated ", textA, htmlA, null);
			AsyncProcessor.scheduleEmail(emailInfo);
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}