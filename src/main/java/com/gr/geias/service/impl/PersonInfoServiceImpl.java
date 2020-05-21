package com.gr.geias.service.impl;

import com.gr.geias.entity.PersonInfo;
import com.gr.geias.mapper.PersonInfoMapper;
import com.gr.geias.service.PersonInfoService;
import com.gr.geias.util.Faseutil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author maotentai
 * @since 2020-03-06
 */
@Service
public class PersonInfoServiceImpl implements PersonInfoService {
    @Autowired
    PersonInfoMapper personInfoMapper;

    @Override
    public PersonInfo login(String username, String password) {
        return personInfoMapper.queryPerson(username, password);
    }

    @Override
    public PersonInfo getPersonById(Integer personId) {
        return personInfoMapper.queryPersonById(personId);
    }

    @Override
    public List<PersonInfo> getCollegePerson() {
        return personInfoMapper.queryCollegePerson();
    }

    @Override
    public List<PersonInfo> getPersonByCollegeId(Integer collegeId) {
        return personInfoMapper.queryPersonByCollegeId(collegeId);
    }

    @Override
    public Boolean insertPerson(PersonInfo personInfo) {
        Integer integer = personInfoMapper.insertPerson(personInfo);
        if (integer > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean updatePerson(PersonInfo personInfo) {
        try {
            Integer integer = personInfoMapper.updatePerson(personInfo);
            if (integer > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Boolean delPerson(Integer personId) {
        Integer integer = personInfoMapper.delPersonById(personId);
        if (integer > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<PersonInfo> getPerson1() {
        return personInfoMapper.queryPerson1();
    }

    @Override
    public Boolean addFace(PersonInfo personInfo, String faseImage) {
        Integer personId = personInfo.getPersonId();
        try {
            JSONObject jsonObject = Faseutil.addUser(faseImage, personId.toString());
            String error_msg = jsonObject.getString("error_msg");
            JSONObject result = jsonObject.getJSONObject("result");
            String face_token = result.getString("face_token");
            if (error_msg.equals("SUCCESS")) {
                Integer integer = personInfoMapper.updatePersonById(personId, face_token);
                if (integer > 0) {
                    personInfo.setFaceToken(face_token);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public PersonInfo checkFace(String image) {
        try {
            JSONObject search = Faseutil.search(image);
            String error_msg = search.getString("error_msg");
            if (error_msg.equals("SUCCESS")){
                JSONObject result = search.getJSONObject("result");
                JSONArray user_list = result.getJSONArray("user_list");
                JSONObject jsonObject = user_list.getJSONObject(0);
                double score = jsonObject.getDouble("score");
                String user_id = jsonObject.getString("user_id");
                if (score>90){
                    return personInfoMapper.queryPersonById(Integer.parseInt(user_id));
                }else {
                    return new PersonInfo();
                }
            }else {
                return null;
            }
        }catch (Exception e){
            return null;
        }
    }
}
