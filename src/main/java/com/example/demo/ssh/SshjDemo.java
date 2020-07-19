package com.example.demo.ssh;

import lombok.extern.slf4j.Slf4j;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.common.IOUtils;
import net.schmizz.sshj.connection.ConnectionException;
import net.schmizz.sshj.connection.channel.direct.Session;
import net.schmizz.sshj.transport.TransportException;
import net.schmizz.sshj.transport.verification.HostKeyVerifier;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;
import net.schmizz.sshj.userauth.keyprovider.OpenSSHKeyFile;
import org.thymeleaf.util.StringUtils;

import java.io.Console;
import java.io.IOException;
import java.security.PublicKey;
import java.util.concurrent.TimeUnit;

/**
 * created by zhenzhong on 2020/7/18
 */
@Slf4j
public class SshjDemo
{
    public static void main(String[] args) throws IOException
    {
        String          cmmand = "cd /usr/local/src/ ;ls -l|grep agent";
        final SSHClient client = new SSHClient();
        //client.loadKnownHosts();
        //client.addHostKeyVerifier(new PromiscuousVerifier());
        //client.addHostKeyVerifier("f0:45:c2:9c:8e:f8:0d:30:dd:b0:74:c6:18:93:58:90");
        client.addHostKeyVerifier(
                new HostKeyVerifier()
                {
                    public boolean verify(String arg0, int arg1, PublicKey arg2)
                    {
                        return true;  // don't bother verifying
                    }
                }
                                 );
        final SshdExecutor sshdExecutor = new SshdExecutor("192.168.31.11", 22, "root", "root", null, null);
        client.setTimeout(120);
        client.setConnectTimeout(120);
        client.connect(sshdExecutor.getIp(), sshdExecutor.getPort());
        if (sshdExecutor.getPrivateKey() != null && sshdExecutor.getPrivateKey().startsWith("-----BEGIN RSA PRIVATE " +
                "KEY-----"))
        {
            final OpenSSHKeyFile openSSHKeyFile = new OpenSSHKeyFile();
            openSSHKeyFile.init(sshdExecutor.getPrivateKey(), sshdExecutor.getPublicKey());
            client.authPublickey(sshdExecutor.getUser(), openSSHKeyFile);
        }
        else
        {
            client.authPassword("root", "root");
        }

        final ExecResponse execResponse = sshExecCmd(client, cmmand);

        closeSSHClien(client);
    }

    private static ExecResponse sshExecCmd(SSHClient client, String cmmand)
    {
        final ExecResponse execResponse = new ExecResponse();
        try (Session session = client.startSession();)
        {
            //client.authPublickey(System.getProperty("user.name"));
            final Session.Command cmd = session.exec(cmmand);
            cmd.join(5, TimeUnit.SECONDS);

            final String returnMsg = IOUtils.readFully(cmd.getInputStream()).toString();
            if (!StringUtils.isEmpty(returnMsg))
            {
                execResponse.setReturnMsg(returnMsg);
            }
            execResponse.setReturnCode(cmd.getExitStatus());
        }
        catch (IOException e)
        {
            log.error("ssh exec cmd failed, because: " + e.getMessage());
        }

        return execResponse;
    }

    private static void closeSSHClien(SSHClient client)
    {
        if (client != null)
        {
            try
            {
                client.close();
            }
            catch (IOException e)
            {
                log.error("close sshClient failed,cause: " + e.getMessage());
            }
        }
    }
}
