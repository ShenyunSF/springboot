package com.example.demo.ssh;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.sshd.client.SshClient;
import org.apache.sshd.client.channel.ClientChannel;
import org.apache.sshd.client.channel.ClientChannelEvent;
import org.apache.sshd.client.future.AuthFuture;
import org.apache.sshd.client.session.ClientSession;
import org.apache.sshd.common.util.security.SecurityUtils;
import org.springframework.stereotype.Component;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

/**
 * created by zhenzhong on 2020/7/11
 */
@Component
@Slf4j
public class SshdExecutor
{
    public SshdExecutor(String ip, Integer port, String user)
    {

    }

    public static void main(String[] args)
    {
        String          cmd       = "ip addr";
        final SshClient sshClient = SshClient.setUpDefaultClient();
        sshClient.start();
        try (
                final ClientSession
                        session = sshClient.connect("root", "192.168.31.182", 22).verify().getSession()
        )
        {
            session.addPasswordIdentity("bazhang421");
            //session.addPublicKeyIdentity(...key-pair...); // for password-less authentication
            // Note: can add BOTH password AND public key identities - depends on the client/server security setup
            final AuthFuture verify = session.auth().verify();
            if (!verify.isSuccess())
            {
                System.out.println("远程连接失败");
                ;
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    SshClient client;

    ClientSession session;

    private String ip;

    private Integer port;

    private String user;

    private String password;

    private String publicKey;

    private String privateKey;

    public String getIp()
    {
        return ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public Integer getPort()
    {
        return port;
    }

    public void setPort(Integer port)
    {
        this.port = port;
    }

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPublicKey()
    {
        return publicKey;
    }

    public void setPublicKey(String publicKey)
    {
        this.publicKey = publicKey;
    }

    public String getPrivateKey()
    {
        return privateKey;
    }

    public void setPrivateKey(String privateKey)
    {
        this.privateKey = privateKey;
    }

    @Getter
    private String result;

    @Getter
    private String error;

    //密码方式
    public SshdExecutor(String ip, Integer port, String user, String password)
    {
        this(ip, port, user);
        session.addPasswordIdentity(password);
    }


    //公钥方式
    public SshdExecutor(String ip, Integer port, String user, String keyName, String publicKey)
    {
        this(ip, port, user);
        try
        {
            session.addPublicKeyIdentity(SecurityUtils.loadKeyPairIdentities(keyName,
                    new ByteArrayInputStream(publicKey.getBytes()), null));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (GeneralSecurityException e)
        {
            e.printStackTrace();
        }
    }


    //执行命令
    public void execute(String command)
    {
        try
        {
            if (!session.auth().verify(10 * 1000).isSuccess())
            {
                throw new Exception("auth faild");
            }

            ClientChannel         channel = session.createExecChannel(command);
            ByteArrayOutputStream out     = new ByteArrayOutputStream();
            ByteArrayOutputStream err     = new ByteArrayOutputStream();
            channel.setOut(out);
            channel.setErr(err);

            if (!channel.open().verify(10 * 1000).isOpened())
            {
                throw new Exception("open faild");
            }
            List<ClientChannelEvent> list = new ArrayList<>();
            list.add(ClientChannelEvent.CLOSED);
            channel.waitFor(list, 10 * 1000);
            channel.close();
            result = out.toString();
            error  = err.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (client != null)
            {
                try
                {
                    client.stop();
                    client.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

}
