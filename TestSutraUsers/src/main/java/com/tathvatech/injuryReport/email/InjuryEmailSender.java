package com.tathvatech.injuryReport.email;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.tathvatech.testsutra.injury.common.InjuryQuery;
import com.tathvatech.testsutra.injury.common.WatcherBean;
import com.tathvatech.testsutra.injury.common.WatcherQuery;
import com.tathvatech.testsutra.injury.web.InjuryReportPrinter;
import com.tathvatech.ts.caf.ApplicationProperties;
import com.tathvatech.ts.core.UserContext;
import com.tathvatech.ts.core.accounts.User;
import com.tathvatech.ts.core.accounts.delegate.AccountDelegate;
import com.tathvatech.ts.core.authorization.AuthorizationManager;
import com.tathvatech.ts.core.common.Attachment;
import com.tathvatech.ts.core.common.EntityTypeEnum;
import com.tathvatech.ts.core.common.utils.AsyncProcessor;
import com.tathvatech.ts.core.common.utils.AttachmentIntf;
import com.tathvatech.ts.core.common.utils.EmailMessageInfo;
import com.tathvatech.ts.core.sites.SiteOID;
import com.tathvatech.ts.core.sites.SiteRolesEnum;
import com.tathvatech.ts.core.utils.TempFileUtil;

public class InjuryEmailSender
{
    public static void notifyInjuryReportSupervisorChanged(UserContext context, InjuryQuery injuryQuery,
                                                           User previousSupervisor)
    {
        try
        {
            StringBuffer sbText = new StringBuffer();
            StringBuffer sbHtml = new StringBuffer();
            sbText.append("Hi\n\n")
                    .append("In Injury report " + injuryQuery.getInjuryReportNo() + ", supervisor changed from ")
                    .append(previousSupervisor.getDisplayString()).append(" to ")
                    .append(injuryQuery.getSupervisedByName()).append(". Please find the report attached. \n\n");
            sbText.append("Thank You\n").append("TestSutra Support\n");

            sbHtml.append("Hi<br/><br/>").append("In Injury report <b>").append(injuryQuery.getInjuryReportNo())
                    .append("</b>, supervisor changed from <b>").append(previousSupervisor.getDisplayString())
                    .append("</b>  to <b>").append(injuryQuery.getSupervisedByName()).append("</b> ")
                    .append(" Please find the report attached. <br/><br/>");
            sbHtml.append("Thank You<br/>").append("TestSutra Support<br/>");

            String text = sbText.toString();
            String html = sbHtml.toString();
            String subject = "Injury report " + injuryQuery.getInjuryReportNo() + " Supervisor Changed";

            sendEmailforSuperVisorChange(context, subject, text, html, injuryQuery, previousSupervisor);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static void notifyInjuryReportCreated(UserContext context, InjuryQuery injuryQuery)
    {

        try
        {
            StringBuffer sbText = new StringBuffer();
            StringBuffer sbHtml = new StringBuffer();
            String createdByName = injuryQuery.getCreatedByName();
            if (createdByName == null || createdByName.trim().length() == 0)
                createdByName = injuryQuery.getCreatedByInitial();

            sbText.append("Hi\n\n").append("A new Injury report <b>").append(injuryQuery.getInjuryReportNo());
            String projectAndLocation = "";
            if (injuryQuery.getProjectName() != null)
            {
                projectAndLocation = " Project <i>" + injuryQuery.getProjectName() + "</i>/ ";
            }
            projectAndLocation = projectAndLocation + " Location <i>" + injuryQuery.getLocationName() + "</i>";
            sbText.append("</b> from").append(projectAndLocation);
            sbText.append(" has been submitted by ").append(createdByName);
            sbText.append(" for verification by ").append(injuryQuery.getSupervisedByName()).append(".");
            sbText.append(" Please find the report attached. \n\n");
            sbText.append("Thank You\n").append("TestSutra Support\n");

            sbHtml.append("Hi<br/><br/>").append("A new Injury report <b>").append(injuryQuery.getInjuryReportNo())
                    .append("</b> from").append(projectAndLocation).append(" has been submitted by ").append(createdByName)
                    .append(" for verification by ").append(injuryQuery.getSupervisedByName()).append(".")
                    .append(" Please find the report attached. <br/><br/>");
            sbHtml.append("Thank You<br/>").append("TestSutra Support<br/>");

            String text = sbText.toString();
            String html = sbHtml.toString();
            String subject = "New Injury report " + injuryQuery.getInjuryReportNo() + " submitted";
            sendEmail(context, subject, text, html, injuryQuery);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void notifyVerifyInjuryReport(UserContext context, InjuryQuery injuryQuery)
    {

        try
        {
            StringBuffer sbText = new StringBuffer();
            StringBuffer sbHtml = new StringBuffer();
            sbText.append("Hi\n\n")
                    .append("Injury report <b>" + injuryQuery.getInjuryReportNo() + "</b> has been verified by ")
                    .append(injuryQuery.getVerifiedByName()).append(". Please find the report attached. \n\n");
            sbText.append("Thank You\n").append("TestSutra Support\n");

            sbHtml.append("Hi<br/><br/>")
                    .append("Injury report <b>" + injuryQuery.getInjuryReportNo() + "</b> has been verified by ")
                    .append(injuryQuery.getVerifiedByName()).append(". Please find the report attached. <br/><br/>");
            sbHtml.append("Thank You<br/>").append("TestSutra Support<br/>");

            String text = sbText.toString();
            String html = sbHtml.toString();
            String subject = "New Injury report " + injuryQuery.getInjuryReportNo() + " verified";

            sendEmail(context, subject, text, html, injuryQuery);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void notifyCloseInjuryReport(UserContext context, InjuryQuery injuryQuery)
    {

        try
        {
            StringBuffer sbText = new StringBuffer();
            StringBuffer sbHtml = new StringBuffer();
            sbText.append("Hi\n\n").append("Injury report " + injuryQuery.getInjuryReportNo() + " has been closed by ")
                    .append(injuryQuery.getClosedByName()).append(". Please find the report attached. \n\n");
            sbText.append("Thank You\n").append("TestSutra Support\n");

            sbHtml.append("Hi<br/><br/>")
                    .append("Injury report <b>" + injuryQuery.getInjuryReportNo() + "</b> has been closed by ")
                    .append(injuryQuery.getClosedByName()).append(". Please find the report attached. <br/><br/>");
            sbHtml.append("Thank You<br/>").append("TestSutra Support<br/>");

            String text = sbText.toString();
            String html = sbHtml.toString();
            String subject = "New Injury report " + injuryQuery.getInjuryReportNo() + " closed";

            sendEmail(context, subject, text, html, injuryQuery);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void notifyReopenInjuryReport(UserContext context, InjuryQuery injuryQuery)
    {

        try
        {
            StringBuffer sbText = new StringBuffer();
            StringBuffer sbHtml = new StringBuffer();

            sbText.append("Hi\n\n").append("Injury report <b>").append(injuryQuery.getInjuryReportNo());
            String projectAndLocation = "";
            if (injuryQuery.getProjectName() != null)
            {
                projectAndLocation = " Project <i>" + injuryQuery.getProjectName() + "</i>/ ";
            }
            projectAndLocation = projectAndLocation + " Location <i>" + injuryQuery.getLocationName() + "</i>";
            sbText.append("</b> from").append(projectAndLocation);
            sbText.append(" has been reopened by ")
                    .append(context.getUser().getFirstName() + " " + context.getUser().getLastName());
            sbText.append(" for verification by ").append(injuryQuery.getSupervisedByName()).append(".");
            sbText.append(" Please find the report attached. \n\n");
            sbText.append("Thank You\n").append("TestSutra Support\n");

            sbHtml.append("Hi<br/><br/>").append("Injury report <b>").append(injuryQuery.getInjuryReportNo())
                    .append("</b> from").append(projectAndLocation).append(" has been reopened by ")
                    .append(context.getUser().getFirstName() + " " + context.getUser().getLastName())
                    .append(" for verification by ").append(injuryQuery.getSupervisedByName()).append(".")
                    .append(" Please find the report attached. <br/><br/>");
            sbHtml.append("Thank You<br/>").append("TestSutra Support<br/>");

            String text = sbText.toString();
            String html = sbHtml.toString();
            String subject = "New Injury report " + injuryQuery.getInjuryReportNo() + " reopened";

            sendEmail(context, subject, text, html, injuryQuery);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void sendEmail(UserContext context, String subject, String text, String html, InjuryQuery iQ)
            throws Exception
    {
        List<Integer> sentList = new ArrayList<>();
        List<String> userListArr = new ArrayList<String>();

        ByteArrayOutputStream pdfPrintStream = new InjuryReportPrinter(context).printForm(iQ);
        String tempFile = TempFileUtil.getNewTempFile();
        File pdfFile = new File(tempFile);
        FileOutputStream mbuffer = new FileOutputStream(pdfFile);
        pdfPrintStream.writeTo(mbuffer);

        System.out.println("FileName:" + pdfFile.getName());
        List<AttachmentIntf> emailAttachments = new ArrayList();
        Attachment att = new Attachment();
        att.setFullFilePath(tempFile);
        att.setFileDisplayName("InjuryReport_" + iQ.getInjuryReportNo() + ".pdf");
        emailAttachments.add(att);

        // email to person who created the report
        if (iQ.getCreatedBy() != null)
        {
            User user = AccountDelegate.getUser(iQ.getCreatedBy());
            if (user != null && user.getEmail() != null && User.STATUS_ACTIVE.equals(user.getStatus()))
            {
                if (!(sentList.contains(user.getPk())))
                {
                    userListArr.add(user.getEmail());
//					EmailMessageInfo emailInfo = new EmailMessageInfo(ApplicationProperties.getEmailFromAddress(), null,
//							new String[] { user.getEmail() }, subject, text, html, emailAttachments);
//					AsyncProcessor.scheduleEmail(emailInfo);

                    sentList.add(user.getPk());
                }
            }
        }

        /*
         * Additional notifiers
         */
        if (iQ.getWatcherBean() != null)
        {
            for (WatcherBean watcherBean : iQ.getWatcherBean())
            {
                User user = AccountDelegate.getUser(watcherBean.getUserPk());
                if (user != null && user.getEmail() != null && User.STATUS_ACTIVE.equals(user.getStatus()))
                {
                    if (!(sentList.contains(user.getPk())))
                    {
//						EmailMessageInfo emailInfo = new EmailMessageInfo(ApplicationProperties.getEmailFromAddress(), null,
//								new String[] { user.getEmail() }, subject, text, html, emailAttachments);
//						AsyncProcessor.scheduleEmail(emailInfo);
                        userListArr.add(user.getEmail());
                        sentList.add(user.getPk());
                    }
                }
            }
        }

        // email to supervisor
        if (iQ.getSupervisedBy() != null)
        {
            User user = AccountDelegate.getUser(iQ.getSupervisedBy());
            if (user != null && user.getEmail() != null && User.STATUS_ACTIVE.equals(user.getStatus()))
            {
                if (!(sentList.contains(user.getPk())))
                {
//					EmailMessageInfo emailInfo = new EmailMessageInfo(ApplicationProperties.getEmailFromAddress(), null,
//							new String[] { user.getEmail() }, subject, text, html, emailAttachments);
//					AsyncProcessor.scheduleEmail(emailInfo);
                    userListArr.add(user.getEmail());
                    sentList.add(user.getPk());
                }
            }
        }

        // email to hsc coordinators

        try
        {
            List<User> users = new AuthorizationManager().getUsersInRole(new SiteOID(iQ.getSitePk(), null),
                    SiteRolesEnum.HSECoordinator);

            for (Iterator iterator = users.iterator(); iterator.hasNext();)
            {
                User user = (User) iterator.next();
                if (user != null && user.getEmail() != null && User.STATUS_ACTIVE.equals(user.getStatus()))
                {
                    if (!(sentList.contains(user.getPk())))
                    {
//						EmailMessageInfo emailInfo = new EmailMessageInfo(ApplicationProperties.getEmailFromAddress(),
//								null, new String[] { user.getEmail() }, subject, text, html, emailAttachments);
//						AsyncProcessor.scheduleEmail(emailInfo);
                        userListArr.add(user.getEmail());

                        sentList.add(user.getPk());
                    }
                }
            }

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        if (userListArr != null && userListArr.size() > 0)
        {
            Object[] objuserListArr = userListArr.toArray();
            String[] userList = Arrays.copyOf(objuserListArr, objuserListArr.length, String[].class);
            EmailMessageInfo emailInfo = new EmailMessageInfo(ApplicationProperties.getEmailFromAddress(), null,
                    userList, subject, text, html, emailAttachments);
            AsyncProcessor.scheduleEmail(emailInfo);


        }

//		// email to additional watchers
//		try
//		{
//			List<WatcherQuery> ListWatcher = WatcherManager.getWatcherByObjectTypeAndObjectPk(iQ.getPk(),
//					EntityTypeEnum.Injury);
//
//			for (Iterator iterator = ListWatcher.iterator(); iterator.hasNext();)
//			{
//				WatcherQuery watcherQuery = (WatcherQuery) iterator.next();
//				if (watcherQuery.getPk() == 0)
//				{
//					continue;
//				}
//
//				User user = AccountDelegate.getUser(watcherQuery.getUserPk());
//				if (user != null && user.getEmail() != null && User.STATUS_ACTIVE.equals(user.getStatus()))
//				{
//					if (!(sentList.contains(user.getPk())))
//					{
//						EmailMessageInfo emailInfo = new EmailMessageInfo(ApplicationProperties.getEmailFromAddress(),
//								null, new String[] { user.getEmail() }, subject, text, html, emailAttachments);
//						AsyncProcessor.scheduleEmail(emailInfo);
//						sentList.add(user.getPk());
//					}
//				}
//			}
//		}
//		catch (Exception ex)
//		{
//			ex.printStackTrace();
//		}
    }

    public static void sendEmailforSuperVisorChange(UserContext context, String subject, String text, String html,
                                                    InjuryQuery iQ, User previousSupervisor) throws Exception
    {
        List<Integer> sentList = new ArrayList<>();

        ByteArrayOutputStream pdfPrintStream = new InjuryReportPrinter(context).printForm(iQ);
        String tempFile = TempFileUtil.getNewTempFile();
        File pdfFile = new File(tempFile);
        FileOutputStream mbuffer = new FileOutputStream(pdfFile);
        pdfPrintStream.writeTo(mbuffer);

        System.out.println("FileName:" + pdfFile.getName());
        List<AttachmentIntf> emailAttachments = new ArrayList();
        Attachment att = new Attachment();
        att.setFullFilePath(tempFile);
        att.setFileDisplayName("InjuryReport_" + iQ.getInjuryReportNo() + ".pdf");
        emailAttachments.add(att);

        // email to person who created the report
        if (iQ.getCreatedBy() != null)
        {
            User user = AccountDelegate.getUser(iQ.getCreatedBy());
            if (user != null && user.getEmail() != null && User.STATUS_ACTIVE.equals(user.getStatus()))
            {
                if (!(sentList.contains(user.getPk())))
                {
                    EmailMessageInfo emailInfo = new EmailMessageInfo(ApplicationProperties.getEmailFromAddress(), null,
                            new String[] { user.getEmail() }, subject, text, html, emailAttachments);
                    AsyncProcessor.scheduleEmail(emailInfo);

                    sentList.add(user.getPk());
                }
            }
        }

        // email to supervisor
        if (iQ.getSupervisedBy() != null)
        {
            User user = AccountDelegate.getUser(iQ.getSupervisedBy());
            if (user != null && user.getEmail() != null && User.STATUS_ACTIVE.equals(user.getStatus()))
            {
                if (!(sentList.contains(user.getPk())))
                {
                    EmailMessageInfo emailInfo = new EmailMessageInfo(ApplicationProperties.getEmailFromAddress(), null,
                            new String[] { user.getEmail() }, subject, text, html, emailAttachments);
                    AsyncProcessor.scheduleEmail(emailInfo);
                    sentList.add(user.getPk());
                }
            }
        }

        // email to previous supervisor

        if (previousSupervisor != null && previousSupervisor.getEmail() != null)
        {
            if (!(sentList.contains(previousSupervisor.getPk())))
            {
                EmailMessageInfo emailInfo = new EmailMessageInfo(ApplicationProperties.getEmailFromAddress(), null,
                        new String[] { previousSupervisor.getEmail() }, subject, text, html, emailAttachments);
                AsyncProcessor.scheduleEmail(emailInfo);
                sentList.add(previousSupervisor.getPk());
            }
        }

        // email to hsc coordinators

        try
        {
            List<User> users = new AuthorizationManager().getUsersInRole(new SiteOID(iQ.getSitePk(), null),
                    SiteRolesEnum.HSECoordinator);

            for (Iterator iterator = users.iterator(); iterator.hasNext();)
            {
                User user = (User) iterator.next();
                if (user != null && user.getEmail() != null && User.STATUS_ACTIVE.equals(user.getStatus()))
                {
                    if (!(sentList.contains(user.getPk())))
                    {
                        EmailMessageInfo emailInfo = new EmailMessageInfo(ApplicationProperties.getEmailFromAddress(),
                                null, new String[] { user.getEmail() }, subject, text, html, emailAttachments);
                        AsyncProcessor.scheduleEmail(emailInfo);

                        sentList.add(user.getPk());
                    }
                }
            }

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        // email to additional watchers
        try
        {
            List<WatcherQuery> ListWatcher = WatcherManager.getWatcherByObjectTypeAndObjectPk(iQ.getPk(),
                    EntityTypeEnum.Injury);

            for (Iterator iterator = ListWatcher.iterator(); iterator.hasNext();)
            {
                WatcherQuery watcherQuery = (WatcherQuery) iterator.next();
                if (watcherQuery.getPk() == 0)
                {
                    continue;
                }

                User user = AccountDelegate.getUser(watcherQuery.getUserPk());
                if (user != null && user.getEmail() != null && User.STATUS_ACTIVE.equals(user.getStatus()))
                {
                    if (!(sentList.contains(user.getPk())))
                    {
                        EmailMessageInfo emailInfo = new EmailMessageInfo(ApplicationProperties.getEmailFromAddress(),
                                null, new String[] { user.getEmail() }, subject, text, html, emailAttachments);
                        AsyncProcessor.scheduleEmail(emailInfo);
                        sentList.add(user.getPk());
                    }
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}

