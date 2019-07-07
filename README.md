#JavaMail

To send an e-mail using your Java Application is simple enough but to start with you should have JavaMail API 
and Java Activation Framework (JAF) installed on your machine.

###Links
- https://javaee.github.io/javamail/
- https://www.tutorialspoint.com/javamail_api/index.htm

###Testing emails: GreenMail
- default hostname: 127.0.0.1 (localhost)
- standalone: http://www.icegreen.com/greenmail/#deployment

-Dgreenmail.setup.all

- SMTP : 25
- SMTPS : 465
- IMAP : 143
- IMAPS : 993
- POP3 : 110
- POP3S : 995

-Dgreenmail.setup.test.all

- SMTP : 3025
- SMTPS : 3465
- IMAP : 3143
- IMAPS : 3993
- POP3 : 3110
- POP3S : 3995

-Dgreenmail.smtp.port=3025 -Dgreenmail.imap.port=3143 -Dgreenmail.hostname=0.0.0.0

###Docker standalone email server
docker run -t -i -p 3025:3025 -p 3110:3110 -p 3143:3143 -p 3465:3465 -p 3993:3993 -p 3995:3995 greenmail/standalone:1.5.10


###Checking 
an email in JavaMail is a process where we open the respective folder in the mailbox and get each message. Here we only check the header of each message i.e the From, To, subject. Content is not read.

###Fetching 
an email in JavaMail is a process where we open the respective folder in the mailbox and get each message. Alongwith the header we also read the content by recognizing the content-type.