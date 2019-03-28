package br.ufrn.imd.obama.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class GerenciadorEmail {

    public GerenciadorEmail() {
    }

    public static void enviarEmail(String destino, String assunto, String conteudo) {

        Properties props = new Properties();
        /** Parâmetros de conexão com servidor Gmail */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("obama@imd.ufrn.br", "IMD2016ufrn");
            }
        });
        /** Ativa Debug para sessão */
        session.setDebug(true);
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("obama@imd.ufrn.br")); // Remetente

            Address[] toUser = InternetAddress // Destinatário(s)
                    .parse(destino);
            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(assunto);// Assunto
            message.setText(conteudo);
            /** Método para enviar a mensagem criada */
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
