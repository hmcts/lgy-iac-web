/usr/local/bin/aws s3 sync /opt/moj/IACFees.files/Backup/ s3://iacfees-tp-staging/IACFees_backup/ # comment to hide end of line garbage
/usr/local/bin/aws s3 sync /opt/moj/IACFees.files/IAC_Submissions/PDF_Files/ s3://iacfees-tp-staging/IACFees.files/IAC_Submissions/PDF_Files/ # comment to hide end of line garbage
/usr/local/bin/aws s3 sync /opt/moj/IACFees.files/IAC_Submissions/XML_Files/ s3://iacfees-tp-staging/IACFees.files/IAC_Submissions/XML_Files/ # comment to hide end of line garbageZZ
mv /opt/moj/IACFees.files/IAC_Submissions/IAC_Submissions/PDF_Files/*.pdf /opt/moj/IACFees.files/Backup   # comment to hide end of line garbage
mv /opt/moj/IACFees.files/IAC_Submissions/IAC_Submissions/XML_Files/*.xml /opt/moj/IACFees.files/Backup  # comment to hide end of line garbage
exit /b %ERRORLEVEL%  # comment to hide end of line garbage