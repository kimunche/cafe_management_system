package com.example.cms.member.controller.request;

import com.example.cms.member.domain.Member;
import com.example.cms.member.domain.MemberStatus;
import com.example.cms.member.domain.UserRoleEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignRequest {
    @NotEmpty
    private String mobile;
    @NotBlank
    private String name;
    private MemberStatus status;

    @NotBlank(message = "비밀번호를 입력해주세요")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,30}$",
            message = "비밀번호는 8~30 자리이면서 1개 이상의 알파벳, 숫자, 특수문자를 포함해야합니다.")
    private String password;

    private UserRoleEnum role;

    @Builder
    public SignRequest(String mobile, String name, MemberStatus status, String password, UserRoleEnum role) {
        this.mobile = mobile;
        this.name = name;
        this.status = status;
        this.password = password;
        this.role = role;
    }


    public Member toEntity(String password, UserRoleEnum role){
        return Member.builder()
                .mobile(mobile)
                .name(name)
                .status(MemberStatus.OPEN)
                .password(password)
                .role(role)
                .build();
    }
}
