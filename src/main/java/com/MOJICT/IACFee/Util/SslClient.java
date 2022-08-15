package com.MOJICT.IACFee.Util;

import javax.net.ssl.*; 
import javax.net.SocketFactory; 
import java.net.*; 
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.math.BigInteger;
import org.apache.commons.httpclient.*; 
import org.apache.commons.httpclient.methods.PostMethod; 
import org.apache.commons.httpclient.protocol.*; 



public class SslClient { 
 private String privateKey; 
 private String  host; 
 private int port; 
 private String userName; 
 private Header [] headers = null; 
 
 public class MySSLSocketFactory implements SecureProtocolSocketFactory { 
  private TrustManager[] getTrustManager() { 
   TrustManager[] trustAllCerts = new TrustManager[]{ 
    new X509TrustManager() { 
     public java.security.cert.X509Certificate[] getAcceptedIssuers() 
{ 
      return null; 
          } 
     public void checkClientTrusted( 
             java.security.cert.X509Certificate[] certs, String 
authType) { 
          } 
     public void checkServerTrusted( 
             java.security.cert.X509Certificate[] certs, String 
authType) { 
          } 
        } 
      }; 
   return trustAllCerts; 
    } 
                 
  public Socket createSocket(String host, int port) throws IOException, 
UnknownHostException { 
   TrustManager[] trustAllCerts = getTrustManager(); 
   try { 
    SSLContext sc = SSLContext.getInstance("SSL"); 
    sc.init(null, trustAllCerts, new java.security.SecureRandom()); 
   
 HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory()); 
    SocketFactory socketFactory = 
HttpsURLConnection.getDefaultSSLSocketFactory(); 
    return socketFactory.createSocket(host, port); 
      } 
   catch (Exception ex) { 
    throw new UnknownHostException("Problems to connect " + host + 
ex.toString()); 
      } 
    } 
  public Socket createSocket(Socket socket, String host, int port, boolean 
flag) throws IOException, UnknownHostException { 
   TrustManager[] trustAllCerts = getTrustManager(); 
   try { 
    SSLContext sc = SSLContext.getInstance("SSL"); 
    sc.init(null, trustAllCerts, new java.security.SecureRandom()); 
     
 HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory()); 
    SocketFactory socketFactory = 
HttpsURLConnection.getDefaultSSLSocketFactory(); 
    return socketFactory.createSocket(host, port); 
      } 
   catch (Exception ex) { 
    throw new UnknownHostException("Problems to connect " + host + 
ex.toString()); 
      } 
    } 
  public Socket createSocket(String host, int port, InetAddress clientHost, 
int clientPort) throws IOException, UnknownHostException { 
   TrustManager[] trustAllCerts = getTrustManager(); 
   try { 
    SSLContext sc = SSLContext.getInstance("SSL"); 
    sc.init(null, trustAllCerts, new java.security.SecureRandom()); 
     
 HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory()); 
    SocketFactory socketFactory = 
HttpsURLConnection.getDefaultSSLSocketFactory(); 
    return socketFactory.createSocket(host, port, clientHost, 
clientPort); 
      } 
   catch (Exception ex) { 
    throw new UnknownHostException("Problems to connect " + host + 
ex.toString()); 
      } 
    } 
 } 
    public SslClient(String host, int port, String userName, String 
privateKey) { 
     this.host=host; 
     this.port = port; 
     this.userName = userName; 
     this.privateKey = privateKey; 
       } 
 protected  String bytesToHex(byte[] bytes) { 
        String s = new String(); 
        BigInteger bi = new BigInteger(1,bytes); 
        // Format to hexadecimal 
        s = bi.toString(16);            // 120ff0 
        if (s.length() % 2 != 0) { 
            // Pad with 0 
            s = "0" + s; 
        } 
        return s; 
    } 
 public String getSignature(String xml) { 
  String signature = new String(); 
  try { 
   MessageDigest md5 = MessageDigest.getInstance("MD5"); 
   String concat = xml + privateKey; 
   concat = bytesToHex(md5.digest(concat.getBytes())); 
   signature = 
bytesToHex(md5.digest(concat.concat(privateKey).getBytes())); 
    } 
  catch (Exception ex) { 
    } 
  return signature; 
 } 
 public String sendRequest(String xml) throws Exception { 
  HttpClient client = new HttpClient(); 
  client.setConnectionTimeout(60000); 
  client.setTimeout(60000); 
  String response = new String(); 
  String portStr = String.valueOf(port); 
  Protocol.registerProtocol("https", new Protocol("https", new 
MySSLSocketFactory(), port)); 
  String signature = getSignature(xml); 
  String uri = "https://" + host + ":" + portStr + "/"; 
  PostMethod postRequest = new PostMethod(uri); 
  postRequest.addRequestHeader("Content-Length", 
String.valueOf(xml.length())); 
  postRequest.addRequestHeader("Content-Type", "text/xml"); 
  postRequest.addRequestHeader("X-Signature", signature); 
  postRequest.addRequestHeader("X-Username", userName); 
  postRequest.setRequestBody(xml); 
                System.out.println("Sending https request....."+postRequest. 
toString()); 
  try { 
   client.executeMethod(postRequest); 
    } 
  catch (Exception ex) { 
   throw new Exception("Sending post got exception ", ex); 
    } 
  response = postRequest.getResponseBodyAsString(); 
  headers = postRequest.getRequestHeaders(); 
   return response; 
 } 
 public String getPrivateKey() { 
  return privateKey; 
 } 
 public void setPrivateKey(String privateKey) { 
  this.privateKey = privateKey; 
 } 
 public String getHost() { 
  return host; 
 } 
 public void setHost(String host) { 
  this.host = host; 
 } 
 public int getPort() { 
  return port; 
 } 
 public void setPort(int port) { 
  this.port = port; 
 } 
 public String getUserName() { 
  return userName; 
 } 
 public void setUserName(String userName) { 
  this.userName = userName; 
 } 
 public Header[] getHeaders() { 
  return headers; 
 } 
 public void setHeaders(Header[] headers) { 
  this.headers = headers; 
 } 
    
 public static void main(String[] args) { 
        String privateKey = "password1"; 
        String userName = "AITreports"; 
        String host="secure2.mde.epdq.co.uk"; 
        int port = 11500; 
        String xml="<?xml version='1.0' encoding='UTF-8' standalone='no'?><EngineDocList>  <DocVersion>1.0</DocVersion> <EngineDoc>   <ContentType>ReportDoc</ContentType>   <User>       <Name>AITreports</Name>                       <Password>password1</Password>                       <ClientId DataType='S32'>3237</ClientId>   </User>   <Instructions>     <RoutingList>       <Routing>         <Name>CcxReports</Name>       </Routing>     </RoutingList>   </Instructions>   <ReportDoc>     <CompList>       <Comp>         <Name>CcxReports</Name>         <ReportActionList>           <ReportAction>             <ReportName>CCE_Trxn_Report_All_V3</ReportName>             <Start DataType='S32'>1</Start>             <Count DataType='S32'>25</Count>             <ValueList>               <Value>                 <ClientId DataType='S32'>3237</ClientId>                 <TransactionBeginDate DataType='DateTime'>1209953379135</TransactionBeginDate>                 <TransactionEndDate DataType='DateTime'>1309953379143</TransactionEndDate>               </Value>             </ValueList>           </ReportAction>         </ReportActionList>       </Comp>     </CompList>   </ReportDoc> </EngineDoc></EngineDocList>";
    	 

       
        SslClient sslclient = new SslClient(host,port,userName,privateKey); 
        try { 
            String response = sslclient.sendRequest(xml); 
            System.out.println("\nResponse is:\n"+response); 
            
            FileOutputStream file = new FileOutputStream("c://response.xml");
            file.write(response.getBytes());
            file.close();
            
            
        } 
        catch (Exception e) { 
            e.printStackTrace();   
        } 
    } 
}