package org.kartashov;

import com.icegreen.greenmail.configuration.GreenMailConfiguration;
import com.icegreen.greenmail.configuration.UserBean;
import com.icegreen.greenmail.junit.GreenMailRule;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetupTest;
import org.junit.Rule;
import org.junit.Test;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestClass {

    @Rule
    public final GreenMailRule greenMail = new GreenMailRule(ServerSetupTest.ALL);

    @Test
    public void testSomething() throws MessagingException {
        GreenMailUtil.sendTextEmailTest("serhii@gmail.com", "john@gmail.com", "subject", "body");
        MimeMessage[] emails = greenMail.getReceivedMessages();
        GreenMailConfiguration gmc = new GreenMailConfiguration();
        gmc.withUser("Serhii", "Passwd");
        gmc.withUser("serhii@gmail.com", "serhii", "passwd");
        List<UserBean> usersToCreate = gmc.getUsersToCreate();
//        gmc.isAuthenticationDisabled();
//        gmc.withDisabledAuthentication();
        greenMail.withConfiguration(gmc);


        assertEquals(1, emails.length);
        assertEquals("subject", emails[0].getSubject());
        assertEquals("body", GreenMailUtil.getBody(emails[0]));
    }
}
