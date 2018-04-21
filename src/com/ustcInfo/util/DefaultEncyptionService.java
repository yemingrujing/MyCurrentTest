package com.ustcInfo.util;

import javax.crypto.Cipher;

public class DefaultEncyptionService {

	private static final String ALGORITHM = "DES";

    public String encode(String input) throws Exception {
        return byte2hex(encode(input.getBytes(),"cmoscmos".getBytes()));
    }

    public String decode(String input) throws IllegalArgumentException, Exception {
        return new String(decode(hex2byte(input), "cmoscmos".getBytes()));
    }

    private byte[] encode(byte[] input, byte[] key) throws Exception {
        try{
            Cipher c1 = Cipher.getInstance(ALGORITHM);
            c1.init(Cipher.ENCRYPT_MODE, new javax.crypto.spec.SecretKeySpec(key, ALGORITHM));
            return c1.doFinal(input);
        }catch (Exception e){
            throw new Exception("加密异常："+e.getMessage());
        }

    }

    private byte[] decode(byte[] input, byte[] key) throws Exception {
        try {
            Cipher c1 = Cipher.getInstance(ALGORITHM);
            c1.init(Cipher.DECRYPT_MODE, new javax.crypto.spec.SecretKeySpec(key, ALGORITHM));
            return c1.doFinal(input);
        }catch (Exception e){
        	throw new Exception("加密异常："+e.getMessage());
        }
    }

    private String byte2hex(byte[] b) {
        StringBuilder stringBuilder = new StringBuilder();
        String stmp;
        for (byte aB : b) {
            stmp = (Integer.toHexString(aB & 0XFF));
            if (stmp.length() == 1) {
                stringBuilder.append("0").append(stmp);
            } else {
                stringBuilder.append(stmp);
            }
        }
        return stringBuilder.toString().toUpperCase();
    }

    private byte[] hex2byte(String hex) throws IllegalArgumentException {
        if (hex.length() % 2 != 0) {
            throw new IllegalArgumentException();
        }
        char[] arr = hex.toCharArray();
        byte[] b = new byte[hex.length() / 2];
        for (int i = 0, j = 0, l = hex.length(); i < l; i++, j++) {
            String swap =  Character.toString(arr[i++]) + Character.toString(arr[i]);
            Integer byteint = Integer.parseInt(swap, 16) & 0xFF;
            b[j] = byteint.byteValue();
        }
        return b;
    }
    
    public static void main(String[] args) throws Exception {
    	DefaultEncyptionService encyption = new DefaultEncyptionService();
    	System.out.println(encyption.encode("abc"));
    	System.out.println(encyption.decode("04E546B6A488FB8510C02D84EEEF14D3"));
    	System.out.println(encyption.decode("2FA0DED7FBBCE97F5D2633D243DC2E8B"));
	}
}
