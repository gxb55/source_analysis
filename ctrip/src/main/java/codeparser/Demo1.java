package codeparser;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;

/**
 * @author xbguo
 * @date 2024/8/28 19:17
 */
public class Demo1 {
    public static void main(String[] args) throws GitAPIException {
        Demo1 demo1 =new Demo1();
        demo1.remoteClone(null,null);
    }

    private void remoteClone(String clonePath, File localPath) throws GitAPIException {
        // 提供用户名和密码的验证
        UsernamePasswordCredentialsProvider provider = new UsernamePasswordCredentialsProvider("userName", "password");

// clone 仓库到指定目录
        Git git = Git.cloneRepository().setURI("http://git.dev.sh.ctripcorp.com/ztrainbooking/ztrainbooking-order-facade.git")
                .setCredentialsProvider(provider).call();
    }
}
