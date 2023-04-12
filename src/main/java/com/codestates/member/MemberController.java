package com.codestates.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/members")
public class MemberController {
    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto memberPostDto) {
        return new ResponseEntity<>(memberPostDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") @Min(1) long memberId,
                                      @Valid @RequestBody MemberPatchDto memberPatchDto) {
        memberPatchDto.setMemberId(memberId);
        memberPatchDto.setName("홍길동");

        // No need Business logic

        return new ResponseEntity<>(memberPatchDto, HttpStatus.OK);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id")long memberId) {
        System.out.println("# memberId: " + memberId);

        // not implementation
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers() {
        System.out.println("# get Members");

        // not implementation
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") long memberId) {
        // No need business logic

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
