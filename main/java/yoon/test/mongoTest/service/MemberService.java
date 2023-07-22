package yoon.test.mongoTest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yoon.test.mongoTest.domain.Members;
import yoon.test.mongoTest.enums.Role;
import yoon.test.mongoTest.repository.MemberReactiveRepository;
import yoon.test.mongoTest.vo.request.MemberRequest;
import yoon.test.mongoTest.vo.response.MemberResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberReactiveRepository memberReactiveRepository;

    private MemberResponse toResponse(Members member) {
        return new MemberResponse(member.getEmail(), member.getName(), member.getAge(), member.getRoleValue());
    }

    public List<Members> findAll(){

        return memberReactiveRepository.findAll();
    }

    @Transactional
    public MemberResponse save(MemberRequest dto){

        Members member = Members.builder()
                .email(dto.getEmail())
                .name(dto.getName())
                .password(dto.getPassword())
                .age(dto.getAge())
                .role(Role.USER)
                .build();

        return toResponse(memberReactiveRepository.save(member));
    }

    @Transactional
    public MemberResponse update(MemberRequest dto){
        Members savedMember = memberReactiveRepository.findByEmail(dto.getEmail());

        savedMember.setName(dto.getName());
        savedMember.setAge(dto.getAge());
        savedMember.setPassword(dto.getPassword());

        return toResponse(memberReactiveRepository.save(savedMember));
    }

    @Transactional
    public boolean delete(String email){
        try {
            Members member = memberReactiveRepository.findByEmail(email);
            memberReactiveRepository.delete(member);
            return true;
        }catch(Exception e){
            return false;
        }
    }

}
