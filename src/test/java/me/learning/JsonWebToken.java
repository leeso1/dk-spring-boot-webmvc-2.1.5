//package me.learning;
//
//import com.nimbusds.jose.JWSAlgorithm;
//import com.nimbusds.jose.JWSHeader;
//import com.nimbusds.jose.JWSSigner;
//import com.nimbusds.jose.crypto.MACSigner;
//import com.nimbusds.jwt.JWTClaimsSet;
//import com.nimbusds.jwt.SignedJWT;
//import com.sktechx.godmusic.auth.rest.model.vo.JwtTokenVo;
//
//import java.util.Calendar;
//import java.util.Date;
//import java.util.UUID;
//
//public class JsonWebToken {
//    public static void main(String[] args) throws Exception {
//        System.out.println("DEV :" + genenateToken(621L, 621L, EnvironmentConfig.DEV));
//        System.out.println("QA : " + genenateToken(8064793L, 8064793L, EnvironmentConfig.QA));
//        System.out.println("PRD : " + genenateToken(5643882L, 5756683L, EnvironmentConfig.PRD));
//    }
//    private static String genenateToken(Long memberNo, Long characterNo, EnvironmentConfig config) throws Exception {
//        JWSSigner signer = new MACSigner(config.getSecretKey());
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(new Date());
//        cal.add(Calendar.SECOND, 86400);
//        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
//                .subject(memberNo.toString())
//                .issuer(config.getIssuer())
//                .jwtID(UUID.randomUUID().toString().replace("-", ""))
//               .expirationTime(cal.getTime())
//                .claim("gdm", JwtTokenVo.builder().mno(memberNo).cno(characterNo).build())
//                .issueTime(new Date())
//                .build();
//        SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
//        signedJWT.sign(signer);
//        return signedJWT.serialize();
//    }
//    enum EnvironmentConfig {
//        DEV {
//            @Override
//            String getSecretKey() {
//                return "04DF8C13B182D5DFCA2E53BDCAF2D0BC5E5ED23ECCD704A73DF9283C1C00ADC5";
//            }
//            @Override
//            String getIssuer() {
//                return "https://dev-api.musicmates.co.kr";
//            }
//        },
//        QA {
//            @Override
//            String getSecretKey() {
//                return "E393D69717418091CD1297E9D6E956906B357715E8FCEEE5842A89D4140AA909";
//            }
//            @Override
//            String getIssuer() {
//                return "https://qa-api.musicmates.co.kr";
//            }
//        },
//        PRD {
//            @Override
//            String getSecretKey() {
//                return "C17A2D1BF86C29E358C3BF2ABC8694D7834E18F52557B20F9CEC0F26166AA4A3";
//            }
//            @Override
//            String getIssuer() {
//                return "https://api.musicmates.co.kr";
//            }
//        }
//        ;
//        abstract String getSecretKey();
//        abstract String getIssuer();
//    }
//}
