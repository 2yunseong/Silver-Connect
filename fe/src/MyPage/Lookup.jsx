import React from 'react';

const LookUp = ({ name, phone, email }) => {
  return (
    <>
      <div className='name-element flex'>
        <div className='w-1/3'>이름</div>
        <div>{name}</div>
      </div>
      <div className='phone-element flex'>
        <div className='w-1/3'>연락처</div>
        <div>{phone}</div>
      </div>
      <div className='email-element flex'>
        <div className='w-1/3'>이메일</div>
        <div>{email}</div>
      </div>
    </>
  );
};

export default LookUp;
