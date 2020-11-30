package passphrase;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PassphraseGeneratorTests {

    private final List<String> lowers;
    private final List<String> uppers;
    private final List<String> numbers;

    PassphraseGeneratorTests() {
        this.lowers = Arrays.asList("a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z".split(","));
        this.uppers = Arrays.asList("A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z".split(","));
        this.numbers = Arrays.asList("1,2,3,4,5,6,7,8,9,0".split(","));
    }

    @Test
    public void generatePassphraseNotContainUppers(){
        var passphrase = new PassphraseGenerator(true,false,true);
        var notUpperCase =passphrase.generate(1024);
        for(int i = 1;i<=10000;i++)assertNotEquals(uppers,notUpperCase);
    }
    @Test
    public void generatePassphraseBySpecifiedLength(){
        var passphrase = new PassphraseGenerator(true,true,true);
        var length = passphrase.generate(8);
        assertEquals(8,length.length());
    }
    @Test
    public void generateEmptyWhenAllConfiglsFalse(){
        var passphrase = new PassphraseGenerator(false,false,false);
        var empty = passphrase.generate(3);
        assertEquals("",empty);
    }

}
