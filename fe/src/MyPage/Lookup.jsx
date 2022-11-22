import React from 'react';

const LookUp = ({ name, phone, email }) => {
  return (
    <div className='text-2xl font-semibold'>
      <div className='name-element flex py-5'>
        <div className='w-1/3'>이름</div>
        <div className='w-2/3'>{name}</div>
      </div>
      <div className='phone-element flex py-5'>
        <div className='w-1/3'>연락처</div>
        <div className='w-2/3'>{phone}</div>
      </div>
      <div className='email-element flex py-5'>
        <div className='w-1/3'>이메일</div>
        <div className='w-2/3'>{email}</div>
      </div>
    </div>
  );
};

export default LookUp;
