package com.example.demo.model;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "membershippayment")
public class MembershipPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FeeID")
    private int feeID;

    @Column(name = "MemberID")
    private int memberID;

    @Column(name = "PaymentDate")
    private Date paymentDate;

    @Column(name = "Amount", precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(name = "PaymentMethod", length = 50)
    private String paymentMethod;

    @Column(name = "PaymentStatus")
    private boolean paymentStatus;

    @Column(name = "MembershipPeriod", length = 50)
    private String membershipPeriod;

    @Column(name = "ReceiptNumber", length = 20)
    private String receiptNumber;

    @ManyToOne
    @JoinColumn(name = "librarystaff_StaffID")
    private LibraryStaff libraryStaff;

    @ManyToOne
    @JoinColumn(name = "librarymember_MemberID")
    private LibraryMember libraryMember;

}
