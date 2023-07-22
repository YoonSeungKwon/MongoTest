package yoon.test.mongoTest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yoon.test.mongoTest.domain.Members;
import yoon.test.mongoTest.service.MemberService;
import yoon.test.mongoTest.vo.request.MemberRequest;
import yoon.test.mongoTest.vo.response.MemberResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/lists")
    public ResponseEntity<?> getMember(){
        List<Members> result = memberService.findAll();

        return ResponseEntity.ok(result);
    }

    @PostMapping("/link")
    public ResponseEntity<?> saveMember(@RequestBody MemberRequest memberRequest){

        System.out.println(memberRequest.getEmail());

        MemberResponse result = memberService.save(memberRequest);

        return ResponseEntity.ok(result);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateMember(@RequestBody MemberRequest memberRequest){

        MemberResponse result = memberService.update(memberRequest);
        if(result == null)
            return ResponseEntity.badRequest().body("Not Found");
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/unlink/{email}")
    public ResponseEntity<?> deleteMember(@PathVariable String email){
        if(!memberService.delete(email))
            return ResponseEntity.badRequest().body("Not Found");
        return ResponseEntity.ok("User deleted");
    }
}
