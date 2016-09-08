# SimpleEmailNotification
Email notification micro service to update system snapshot view. 

Simple Email Notification: is an micro service to update system snapshot view.
The application is used in crawlers and long-runing algorithms when frequent updats of system status are needed.
You can specify a notification format using "StringBuilder" to create your arbitrary messages.
In addition, you can wrap the class in a timer to indicate the frequency of the messages. 
This application is open source created using javax.mail package.
Please remember to cite our URL (https://www.kth.se/profile/ghoorian/) when use it.

@category Utilities @author kambiz @version 0.1

# How to use
To run the code you can embed the source and run with 4 arguments:

> SendEmail sm = new SendEmail(host);

> boolean res = sm.sendMailTo(from, to, subject, text);

<dl>
  <dt>example args:</dt>
  <dt>host = "smtp.your_host_adderss"</dt>
  <dt>from = "sender_email_id@sender_email_domain"</dt>
  <dt>to = "receiver_email_id@receiver_email_domain"</dt>
  <dt>subject = "email subject"</dt>
  <dt>text = "email content"</dt>
</dl>
