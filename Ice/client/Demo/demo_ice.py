# -*- coding: utf-8 -*-
#
# Copyright (c) ZeroC, Inc. All rights reserved.
#
#
# Ice version 3.7.9
#
# <auto-generated>
#
# Generated from file `demo.ice'
#
# Warning: do not edit this file.
#
# </auto-generated>
#

from sys import version_info as _version_info_
import Ice, IcePy

# Start of module Demo
_M_Demo = Ice.openModule('Demo')
__name__ = 'Demo'

# _M_Demo._t_MyObject = IcePy.defineValue('::Demo::MyObject', Ice.Value, -1, (), False, True, None, ())
# _M_Demo._t_MyObject = Ice.Value('::Demo::MyObject')

if 'MyObjectPrx' not in _M_Demo.__dict__:
    _M_Demo.MyObjectPrx = Ice.createTempClass()
    class MyObjectPrx(Ice.ObjectPrx):

        def getName(self, context=None):
            return _M_Demo.MyObject._op_getName.invoke(self, ((), context))

        def getNameAsync(self, context=None):
            return _M_Demo.MyObject._op_getName.invokeAsync(self, ((), context))

        def begin_getName(self, _response=None, _ex=None, _sent=None, context=None):
            return _M_Demo.MyObject._op_getName.begin(self, ((), _response, _ex, _sent, context))

        def end_getName(self, _r):
            return _M_Demo.MyObject._op_getName.end(self, _r)

        def getId(self, context=None):
            return _M_Demo.MyObject._op_getId.invoke(self, ((), context))

        def getIdAsync(self, context=None):
            return _M_Demo.MyObject._op_getId.invokeAsync(self, ((), context))

        def begin_getId(self, _response=None, _ex=None, _sent=None, context=None):
            return _M_Demo.MyObject._op_getId.begin(self, ((), _response, _ex, _sent, context))

        def end_getId(self, _r):
            return _M_Demo.MyObject._op_getId.end(self, _r)

        @staticmethod
        def checkedCast(proxy, facetOrContext=None, context=None):
            return _M_Demo.MyObjectPrx.ice_checkedCast(proxy, '::Demo::MyObject', facetOrContext, context)

        @staticmethod
        def uncheckedCast(proxy, facet=None):
            return _M_Demo.MyObjectPrx.ice_uncheckedCast(proxy, facet)

        @staticmethod
        def ice_staticId():
            return '::Demo::MyObject'
    _M_Demo._t_MyObjectPrx = IcePy.defineProxy('::Demo::MyObject', MyObjectPrx)

    _M_Demo.MyObjectPrx = MyObjectPrx
    del MyObjectPrx

    _M_Demo.MyObject = Ice.createTempClass()
    class MyObject(Ice.Object):

        def ice_ids(self, current=None):
            return ('::Demo::MyObject', '::Ice::Object')

        def ice_id(self, current=None):
            return '::Demo::MyObject'

        @staticmethod
        def ice_staticId():
            return '::Demo::MyObject'

        def getName(self, current=None):
            raise NotImplementedError("servant method 'getName' not implemented")

        def getId(self, current=None):
            raise NotImplementedError("servant method 'getId' not implemented")

        def __str__(self):
            return IcePy.stringify(self, _M_Demo._t_MyObjectDisp)

        __repr__ = __str__

    _M_Demo._t_MyObjectDisp = IcePy.defineClass('::Demo::MyObject', MyObject, (), None, ())
    MyObject._ice_type = _M_Demo._t_MyObjectDisp

    MyObject._op_getName = IcePy.Operation('getName', Ice.OperationMode.Normal, Ice.OperationMode.Normal, False, None, (), (), (), ((), IcePy._t_string, False, 0), ())
    MyObject._op_getId = IcePy.Operation('getId', Ice.OperationMode.Normal, Ice.OperationMode.Normal, False, None, (), (), (), ((), IcePy._t_int, False, 0), ())

    _M_Demo.MyObject = MyObject
    del MyObject

# End of module Demo
